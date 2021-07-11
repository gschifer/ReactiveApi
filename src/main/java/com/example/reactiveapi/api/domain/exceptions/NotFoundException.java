package com.example.reactiveapi.api.domain.exceptions;

public abstract class NotFoundException extends BussinessException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
