package com.example.reactiveapi.api.domain;

import com.example.reactiveapi.api.domain.entities.Footballer;
import com.example.reactiveapi.api.domain.repository.FootballerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private FootballerRepository footballerRepository;

    @Override
    public void run(String[] args) {
        footballerRepository.deleteAll()
                .thenMany(Flux.just(Footballer.builder().name("João").build(), Footballer.builder().name("Léo").build()))
                .flatMap(footballer -> footballerRepository.save(footballer))
                .subscribe();
    }
}
