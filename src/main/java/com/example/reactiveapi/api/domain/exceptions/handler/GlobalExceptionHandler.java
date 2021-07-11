//package com.example.reactiveapi.api.domain.exceptions.handler;
//
//import org.springframework.boot.autoconfigure.web.ResourceProperties;
//import org.springframework.boot.autoconfigure.web.WebProperties;
//import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
//import org.springframework.boot.web.reactive.error.ErrorAttributes;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.*;
//import reactor.core.publisher.Mono;
//
//@Order(-2)
//@Component
//public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {
//
//    public GlobalExceptionHandler(ErrorAttributes errorAttributes, WebProperties.Resources resources, ApplicationContext applicationContext) {
//        super(errorAttributes, resources, applicationContext);
//    }
//
//    @Override
//    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
//        return RouterFunctions.route(RequestPredicates.all(), handleException);
//    }
//
//    private Mono<ServerResponse> handleException(ServerRequest request) {
//
//    }
//
//}
