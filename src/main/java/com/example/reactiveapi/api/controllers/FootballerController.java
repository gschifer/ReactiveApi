package com.example.reactiveapi.api.controllers;

import com.example.reactiveapi.api.domain.entities.Footballer;
import com.example.reactiveapi.api.dto.FootballerDTO;
import com.example.reactiveapi.api.services.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/footballer")
public class FootballerController {
    private FootballerService footballerService;

    @Autowired
    public FootballerController(FootballerService footballerService) {
        this.footballerService = footballerService;
    }

    @GetMapping("/all")
    public Flux<FootballerDTO> getFootballers() {
        return footballerService.getFootballers();
    }

    @GetMapping("/{id}")
    public Mono<FootballerDTO> getFootballer(@PathVariable("id") String id) {
        return footballerService.getFootballer(id);
    }

    @PostMapping
    public Mono<FootballerDTO> saveFootbaler(@RequestBody @Valid Mono<Footballer> footballer) {
        return footballerService.save(footballer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<Void> deleteFootballer(@PathVariable("id") String id) {
        return footballerService.delete(id);
    }

    @PutMapping("/{id}")
    public Mono<FootballerDTO> updateFootballer(@PathVariable("id") String id,
                                             @RequestBody Mono<Footballer> footballer) {
        return footballerService.update(footballer, id);
    }
}
