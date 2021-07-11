package com.example.reactiveapi.api.prototypes;

import com.example.reactiveapi.api.domain.entities.Footballer;

public class FootballerPrototype {
    public static Footballer anFootballer() {
        return Footballer.builder().name("João").build();
    }
}
