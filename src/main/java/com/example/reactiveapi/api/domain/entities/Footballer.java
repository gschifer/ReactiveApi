package com.example.reactiveapi.api.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "footballers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Footballer {
    @Id
    private String id;

    @NotBlank
    private String name;

    private String club;

    private String strongFoot;

    @Min(16)
    @Max(50)
    private Integer age;

    @Min(150)
    @Max(220)
    private Integer height;

    private String nation;

    private String numberOfGoals;

    private String league;

    private BigDecimal salary;

    @CreatedDate
    @Field(name = "created_at")
    private LocalDateTime createdAt;

}
