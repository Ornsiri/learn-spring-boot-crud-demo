//package com.ornsiri.springboot.demo.crud.service;
//
//import com.ornsiri.springboot.demo.crud.dao.EmployeeDAO;
//import com.ornsiri.springboot.demo.crud.dao.EmployeeRepository;
//import com.ornsiri.springboot.demo.crud.entity.Employee;
//import com.ornsiri.springboot.demo.crud.rest.EmployeeNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//    private EmployeeRepository repository;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return this.repository.findAll();
//    }
//
//    @Override
//    public Employee findById(int id) {
//        Optional<Employee> result = this.repository.findById(id);
//        if (result.isPresent()) {
//            return result.get();
//        }
//        throw new EmployeeNotFoundException("Employee id not found - " + id);
//    }
//
//    @Override
//    public Employee save(Employee employee) {
//        return this.repository.save(employee);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        this.repository.deleteById(id);
//    }
//
//    private EmployeeDAO employeeDAO;
//    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return this.employeeDAO.findAll();
//    }
//
//    @Override
//    public Employee findById(int id) {
//        return employeeDAO.findById(id);
//    }
//
//    @Transactional
//    @Override
//    public Employee save(Employee employee) {
//        return employeeDAO.save(employee);
//    }
//
//    @Transactional
//    @Override
//    public void deleteById(int id) {
//        employeeDAO.deleteById(id);
//    }

//}
