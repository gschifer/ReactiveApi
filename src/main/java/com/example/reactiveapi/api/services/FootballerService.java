package com.example.reactiveapi.api.services;

import com.example.reactiveapi.api.domain.entities.Footballer;
import com.example.reactiveapi.api.domain.exceptions.FootballerNotFoundException;
import com.example.reactiveapi.api.domain.repository.FootballerRepository;
import com.example.reactiveapi.api.dto.FootballerDTO;
import com.example.reactiveapi.api.utils.Utils;
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

    public Flux<FootballerDTO> getFootballers() {
        return footballerRepository.findAll()
                .map(Utils::entityToDto);
    }

    public Mono<FootballerDTO> getFootballer(String id) {
        return footballerRepository.findById(id)
                .map(Utils::entityToDto)
                .switchIfEmpty(Mono.error(new FootballerNotFoundException()));
    }

    public Mono<FootballerDTO> save(Mono<Footballer> footballer) {
        return footballer
                .flatMap(footballerRepository::save)
                .map(Utils::entityToDto);

    }

    public Mono<Void> delete(String id) {
        return getFootballer(id).flatMap(footballer -> footballerRepository.deleteById(footballer.getId()));
    }

    public Mono<FootballerDTO> update(Mono<Footballer> footballer, String id) {
        return footballer
                .flatMap(requestBody -> getFootballer(id).map(Utils::dtoToEntity)
                        .flatMap(footballerToBeUpdated -> {
                            BeanUtils.copyProperties(requestBody, footballerToBeUpdated, "id", "createdAt");

                            return save(Mono.just(footballerToBeUpdated));
                        }));
    }
}
