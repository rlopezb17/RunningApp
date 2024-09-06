package com.runningback.mapper;


import com.runningback.dto.EffortDto;
import com.runningback.entity.Effort;

public class EffortMapper {

    public static EffortDto toEffortDto(Effort effort) {
        EffortDto dto = new EffortDto();
        dto.setId(effort.getId());
        dto.setName(effort.getName());
        return dto;
    }

    public static Effort toEffortEntity(EffortDto dto) {
        Effort effort = new Effort();
        effort.setId(dto.getId());
        effort.setName(dto.getName());
        return effort;
    }

}
