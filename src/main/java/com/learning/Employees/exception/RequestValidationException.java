package com.learning.Employees.exception;

import org.springframework.http.HttpStatus;

public class RequestValidationException extends RuntimeException {

    private final HttpStatus status;

    public  RequestValidationException(String message,HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
