//package com.example.reactiveapi.api.controllers;
//
//import com.example.reactiveapi.api.domain.entities.Footballer;
//import com.example.reactiveapi.api.services.FootballerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//public class FootballerController {
//    private FootballerService footballerService;
//
//    @Autowired
//    public FootballerController(FootballerService footballerService) {
//        this.footballerService = footballerService;
//    }
//
//    @GetMapping("/footballer/all")
//    public ResponseEntity<Flux<Footballer>> getFootballers() {
//        return ResponseEntity.ok(footballerService.getFootballers());
//    }
//
//    @PostMapping("/footballer")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Mono<Footballer>> saveFootballer(@RequestBody Footballer footballer) {
//        return ResponseEntity.ok(footballerService.save(footballer));
//    }
//
//    @GetMapping("/footballer/{id}")
//    public ResponseEntity<Mono<Footballer>> getFootballer(@PathVariable("id") String id) {
//        return ResponseEntity.ok(footballerService.getFootballer(id));
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteFootballer(@PathVariable("id") String id) {
//        footballerService.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Mono<Footballer>> updateFootballer(@RequestBody Mono<Footballer> footballer) {
//        return ResponseEntity.ok(footballerService.update(footballer));
//    }
//}
