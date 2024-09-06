package com.runningback.mapper;

import com.runningback.dto.ActivityDto;
import com.runningback.entity.Activity;

public class ActivityMapper {

    public static ActivityDto toActivityDto(Activity activity) {
        ActivityDto dto = new ActivityDto();
        dto.setId(activity.getId());
        dto.setTitle(activity.getTitle());
        dto.setDescription(activity.getDescription());
        dto.setDistance(activity.getDistance());
        dto.setTime(activity.getTime());
        dto.setPace(activity.getPace());
        dto.setCalories(activity.getCalories());
        dto.setPulse(activity.getPulse());
        dto.setDate(activity.getDate());

        if (activity.getType() != null) {
            dto.setType(TypeMapper.toTypeDto(activity.getType()));
        }

        if (activity.getEffort() != null) {
            dto.setEffort(EffortMapper.toEffortDto(activity.getEffort()));
        }

        return dto;
    }

    public static Activity toActivityEntity(ActivityDto dto) {
        Activity activity = new Activity();
        activity.setId(dto.getId());
        activity.setTitle(dto.getTitle());
        activity.setDescription(dto.getDescription());
        activity.setDistance(dto.getDistance());
        activity.setTime(dto.getTime());
        activity.setPace(dto.getPace());
        activity.setCalories(dto.getCalories());
        activity.setPulse(dto.getPulse());
        activity.setDate(dto.getDate());

        return activity;
    }

}
