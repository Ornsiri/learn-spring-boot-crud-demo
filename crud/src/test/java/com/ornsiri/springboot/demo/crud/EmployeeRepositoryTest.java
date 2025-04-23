package com.ornsiri.springboot.demo.crud;

import com.ornsiri.springboot.demo.crud.dao.EmployeeRepository;
import com.ornsiri.springboot.demo.crud.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @DisplayName("Save employee and retrieve by ID")
    @Test
    void saveEmployeeAndRetrieveById() {
        Employee employee = new Employee("John", "Doe", "john.doe@example.com");
        Employee savedEmployee = employeeRepository.save(employee);

        Employee foundEmployee = employeeRepository.findById(savedEmployee.getId()).orElse(null);

        assertNotNull(foundEmployee);
        assertEquals("John", foundEmployee.getFirstName());
        assertEquals("Doe", foundEmployee.getLastName());
        assertEquals("john.doe@example.com", foundEmployee.getEmail());
    }

    @DisplayName("Find all employees when repository is empty")
    @Test
    void findAllEmployeesWhenRepositoryIsEmpty() {
        List<Employee> employees = employeeRepository.findAll();

        assertTrue(employees.isEmpty());
    }

    @DisplayName("Delete employee by ID")
    @Test
    void deleteEmployeeById() {
        Employee employee = new Employee("Jane", "Smith", "jane.smith@example.com");
        Employee savedEmployee = employeeRepository.save(employee);

        employeeRepository.deleteById(savedEmployee.getId());

        Optional<Employee> deletedEmployee = employeeRepository.findById(savedEmployee.getId());
        assertTrue(deletedEmployee.isEmpty());
    }

    @DisplayName("Find all employees when repository has data")
    @Test
    void findAllEmployeesWhenRepositoryHasData() {
        Employee employee1 = new Employee("Alice", "Brown", "alice.brown@example.com");
        Employee employee2 = new Employee("Bob", "White", "bob.white@example.com");
        entityManager.persist(employee1);
        entityManager.persist(employee2);

        List<Employee> employees = employeeRepository.findAll();

        assertEquals(2, employees.size());
    }

    @DisplayName("Find employee by non-existent ID")
    @Test
    void findEmployeeByNonExistentId() {
        Optional<Employee> employee = employeeRepository.findById(999);

        assertTrue(employee.isEmpty());
    }
}
