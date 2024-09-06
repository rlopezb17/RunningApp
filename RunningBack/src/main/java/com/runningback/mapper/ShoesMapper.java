package com.runningback.mapper;

import com.runningback.dto.ShoesDto;
import com.runningback.entity.Shoes;

public class ShoesMapper {

    public static ShoesDto toShoesDto(Shoes shoes) {
        ShoesDto dto = new ShoesDto();
        dto.setId(shoes.getId());
        dto.setBrand(shoes.getBrand());
        dto.setModel(shoes.getModel());
        return dto;
    }

    public static Shoes toShoesEntity(ShoesDto dto) {
        Shoes shoes = new Shoes();
        shoes.setId(dto.getId());
        shoes.setBrand(dto.getBrand());
        shoes.setModel(dto.getModel());
        return shoes;
    }

}
