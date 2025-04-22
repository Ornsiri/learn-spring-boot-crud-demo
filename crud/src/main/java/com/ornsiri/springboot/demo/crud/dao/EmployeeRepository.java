package com.ornsiri.springboot.demo.crud.dao;

import com.ornsiri.springboot.demo.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No need to define any methods here, JpaRepository provides all the necessary CRUD operations
    // You can add custom query methods if needed
}