package com.example.reactiveapi.api.routers;

import com.example.reactiveapi.api.handlers.FootballerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.*;

import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class FootballerRouter {

    @Bean
    public RouterFunction<ServerResponse> router(FootballerHandler handler) {
        return route(GET("/footballer/all").and(accept(MediaType.APPLICATION_JSON)), handler::getFootballers)
                .andRoute(POST("/footballer").and(accept(MediaType.APPLICATION_JSON)), handler::saveFootballer)
                .andRoute(GET("/footballer/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::getFootballer)
                .andRoute(PUT("/footballer/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::updateFootballer)
                .andRoute(DELETE("/footballer/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::deleteFootballer);
    }
}
