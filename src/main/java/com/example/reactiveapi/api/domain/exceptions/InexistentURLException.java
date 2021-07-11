package com.example.reactiveapi.api.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InexistentURLException extends ResponseStatusException {
    public InexistentURLException(HttpStatus status) {
        super(status);
    }

    public InexistentURLException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
