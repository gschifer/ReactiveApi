package com.example.reactiveapi.api.domain.exceptions;

public class NotFoundException extends BussinessException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
