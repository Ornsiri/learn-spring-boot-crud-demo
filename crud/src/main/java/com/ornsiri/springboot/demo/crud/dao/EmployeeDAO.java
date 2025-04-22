package com.ornsiri.springboot.demo.crud.dao;

import com.ornsiri.springboot.demo.crud.entity.Employee;

import java.util.List;
import java.util.Map;


public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);


}
