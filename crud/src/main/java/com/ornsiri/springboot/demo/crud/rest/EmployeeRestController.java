package com.ornsiri.springboot.demo.crud.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ornsiri.springboot.demo.crud.entity.Employee;
import com.ornsiri.springboot.demo.crud.service.EmployeeService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee foundEmployee = this.employeeService.findById(employeeId);
        if (foundEmployee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }
        return foundEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        newEmployee.setId(0);
        Employee savedEmployee = this.employeeService.save(newEmployee);
        return savedEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = this.employeeService.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee foundEmployee = this.employeeService.findById(employeeId);

        if ( foundEmployee == null) {
            throw  new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }

        this.employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String, Object> patchPayload) {

        Employee employee = this.employeeService.findById(employeeId);

        // check if ID not found
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }

        // check if ID is provided in the requested body
        if (patchPayload.containsKey("id")) {
            throw new EmployeeInternalServerException("Employee id not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = apply(patchPayload, employee);
        Employee savedEmployee = this.employeeService.save(patchedEmployee);

        return savedEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee employee) {
        // Convert employee object into JSON object node.
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        // Convert patchPayload into JSON object as well.
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge patchNode with employeeNode
        employeeNode.setAll(patchNode);

        // Convert back into Employee
        return objectMapper.convertValue(employeeNode, Employee.class);

    }

}
