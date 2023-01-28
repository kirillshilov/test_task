package com.example.test_task.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongParametersException extends RuntimeException {
    public WrongParametersException(String message) {
        super(message);
    }
}
