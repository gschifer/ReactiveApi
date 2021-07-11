package com.example.reactiveapi.api.domain.exceptions;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

@Component
public class CustomAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributesMap = super.getErrorAttributes(request, options);
        errorAttributesMap.remove("requestId");

        Throwable throwable = getError(request);

        if (throwable instanceof ResponseStatusException) {
            return handleInexistingURLException(errorAttributesMap, (ResponseStatusException) throwable);
        }

        if (throwable instanceof FootballerNotFoundException) {
            return handleFootballerNotFoundException(errorAttributesMap, (FootballerNotFoundException) throwable);
        }

        return errorAttributesMap;
    }

    private Map<String, Object> handleInexistingURLException(Map<String, Object> errorAttributesMap,
                                                             ResponseStatusException ex) {
        errorAttributesMap.put("message", "The path you tried to access doesn't exist.");
        return errorAttributesMap;
    }

    private Map<String, Object> handleFootballerNotFoundException(Map<String, Object> errorAttributesMap,
                                                                  FootballerNotFoundException ex) {
        errorAttributesMap.put("message", ex.getMessage());

        return errorAttributesMap;
    }
}