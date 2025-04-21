package com.ornsiri.springboot.demo.crud.service;

import com.ornsiri.springboot.demo.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
