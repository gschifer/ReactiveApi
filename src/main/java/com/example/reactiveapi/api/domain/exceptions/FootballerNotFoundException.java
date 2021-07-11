package com.example.reactiveapi.api.domain.exceptions;

public class FootballerNotFoundException extends NotFoundException{
    private static final long serialVersionUID = 1L;

    public FootballerNotFoundException(String message) {
        super(message);
    }
}
