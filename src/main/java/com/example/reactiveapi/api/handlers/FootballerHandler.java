package com.example.reactiveapi.api.handlers;

import com.example.reactiveapi.api.domain.entities.Footballer;
import com.example.reactiveapi.api.services.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class FootballerHandler {
    @Autowired
    private FootballerService footballerService;

    public Mono<ServerResponse> getFootballers(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(footballerService.getFootballers(), Footballer.class);
    }

    public Mono<ServerResponse> getFootballer(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(footballerService.getFootballer(request.pathVariable("id")), Footballer.class);
    }

    public Mono<ServerResponse> saveFootballer(ServerRequest request) {
        return request.bodyToMono(Footballer.class)
                .flatMap(req -> footballerService.save(req))
                .flatMap(footballer -> created(URI.create("/api/v1/footballer/" + footballer.getId()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .build());
    }

    public Mono<ServerResponse> updateFootballer(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(footballerService.update(request.bodyToMono(Footballer.class), request.pathVariable("id")),
                        Footballer.class);
    }


}
