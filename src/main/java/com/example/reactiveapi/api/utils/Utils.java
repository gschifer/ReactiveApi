package com.example.reactiveapi.api.utils;

import com.example.reactiveapi.api.domain.entities.Footballer;
import com.example.reactiveapi.api.dto.FootballerDTO;
import org.springframework.beans.BeanUtils;

public class Utils {

    public static FootballerDTO entityToDto(Footballer footballer) {
        FootballerDTO footballerDTO = new FootballerDTO();
        BeanUtils.copyProperties(footballer,footballerDTO);

        return footballerDTO;
    }

    public static Footballer dtoToEntity(FootballerDTO footballerDTO) {
        Footballer footballer = new Footballer();
        BeanUtils.copyProperties(footballerDTO, footballer);

        return footballer;
    }
}
