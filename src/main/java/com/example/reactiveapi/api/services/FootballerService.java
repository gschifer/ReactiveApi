package com.example.reactiveapi.api.services;

import com.example.reactiveapi.api.domain.entities.Footballer;
import com.example.reactiveapi.api.domain.exceptions.FootballerNotFoundException;
import com.example.reactiveapi.api.domain.repository.FootballerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return footballerRepository.findById(id).switchIfEmpty(Mono.error(new FootballerNotFoundException()));
    }

    public Mono<Footballer> save(Footballer footballer) {
        return footballerRepository.save(footballer);
    }

    public Mono<Void> delete(String id) {
        return getFootballer(id).flatMap(footballer -> footballerRepository.deleteById(footballer.getId()));
    }

    public Mono<Footballer> update(Mono<Footballer> footballer, String id) {
        return footballer
                .flatMap(footballerUpdateBody -> getFootballer(id)
                        .flatMap(footballerToBeUpdated -> {
                            BeanUtils.copyProperties(footballerUpdateBody, footballerToBeUpdated, "id", "createdAt");
                            return footballerRepository.save(footballerToBeUpdated);
                        }));
    }
}
