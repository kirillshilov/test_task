package com.example.test_task.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BackendErrorException extends RuntimeException{
    public BackendErrorException (String message){
        super(message);
    }
}
