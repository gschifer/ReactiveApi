package com.example.reactiveapi.api.domain.exceptions;

public abstract class BussinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
