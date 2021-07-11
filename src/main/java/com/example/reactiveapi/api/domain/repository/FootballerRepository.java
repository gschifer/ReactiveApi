package com.example.reactiveapi.api.domain.repository;

import com.example.reactiveapi.api.domain.entities.Footballer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballerRepository extends ReactiveMongoRepository<Footballer, String> {
}
