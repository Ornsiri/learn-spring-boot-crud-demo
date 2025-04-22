package com.ornsiri.springboot.demo.crud.rest;

public class EmployeeMethodNotAllowedException extends RuntimeException {
    public EmployeeMethodNotAllowedException(String message) {
        super(message);
    }

    public EmployeeMethodNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeMethodNotAllowedException(Throwable cause) {
        super(cause);
    }
}
