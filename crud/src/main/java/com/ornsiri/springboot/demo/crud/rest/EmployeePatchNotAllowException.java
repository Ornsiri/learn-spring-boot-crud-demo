package com.ornsiri.springboot.demo.crud.rest;

public class EmployeePatchNotAllowException extends RuntimeException {

    public EmployeePatchNotAllowException(String message) {
        super(message);
    }

    public EmployeePatchNotAllowException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeePatchNotAllowException(Throwable cause) {
        super(cause);
    }

}
