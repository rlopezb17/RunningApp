package com.runningback.mapper;

import com.runningback.dto.TypeDto;
import com.runningback.entity.Type;

public class TypeMapper {

    public static TypeDto toTypeDto(Type type) {
        TypeDto dto = new TypeDto();
        dto.setId(type.getId());
        dto.setName(type.getName());
        return dto;
    }

    public static Type toTypeEntity(TypeDto dto) {
        Type type = new Type();
        type.setId(dto.getId());
        type.setName(dto.getName());
        return type;
    }

}
