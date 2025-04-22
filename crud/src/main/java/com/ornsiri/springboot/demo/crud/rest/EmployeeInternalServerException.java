package com.ornsiri.springboot.demo.crud.rest;

public class EmployeeInternalServerException extends RuntimeException {

    public EmployeeInternalServerException(String message) {
        super(message);
    }

    public EmployeeInternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeInternalServerException(Throwable cause) {
        super(cause);
    }
}
