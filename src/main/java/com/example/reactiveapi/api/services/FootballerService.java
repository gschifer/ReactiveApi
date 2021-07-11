package com.example.reactiveapi.api.services;

import com.example.reactiveapi.api.domain.entities.Footballer;
import com.example.reactiveapi.api.domain.exceptions.FootballerNotFoundException;
import com.example.reactiveapi.api.domain.repository.FootballerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FootballerService {

    private FootballerRepository footballerRepository;

    @Autowired
    public FootballerService(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    public Flux<Footballer> getFootballers() {
        return footballerRepository.findAll();
    }

    public Mono<Footballer> getFootballer(String id) {
        return footballerRepository.findById(id);
    }

    public Mono<Footballer> save(Footballer footballer) {
        return footballerRepository.save(footballer);
    }

    public void delete(String id) {
        footballerRepository.deleteById(id);
    }

    public Mono<Footballer> update(Mono<Footballer> footballer, String id) {
        return footballer
                .flatMap(footballerUpdateBody -> footballerRepository.findById(id)
                        .flatMap(footballerToBeUpdated -> {
                            BeanUtils.copyProperties(footballerUpdateBody, footballerToBeUpdated, "id", "createdAt");
                            return footballerRepository.save(footballerToBeUpdated);
                        })
                        .switchIfEmpty(Mono.error
                                (new ResponseStatusException(HttpStatus.BAD_REQUEST, "Footballer not found."))));
    }

}
