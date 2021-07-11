package com.example.reactiveapi.api.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FootballerNotFoundException extends NotFoundException{
    private static final long serialVersionUID = 1L;

    public FootballerNotFoundException(String message) {
        super(message);
    }

    public FootballerNotFoundException() {
        this("Footballer wasn't found.");
    }
}
