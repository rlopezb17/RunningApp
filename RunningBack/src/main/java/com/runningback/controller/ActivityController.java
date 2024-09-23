package com.runningback.controller;

import com.runningback.dto.ActivityDto;
import com.runningback.dto.ApiResponse;
import com.runningback.entity.Activity;
import com.runningback.mapper.ActivityMapper;
import com.runningback.service.IActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    private final IActivityService activityService;

    public ActivityController(IActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/addActivity")
    public ResponseEntity<ApiResponse> addActivity(@RequestBody ActivityDto activityDto) {
        Activity newActivity = ActivityMapper.toActivityEntity(activityDto);
        activityService.addActivity(newActivity);
        return ResponseEntity.ok(new ApiResponse(true, "Activity registered successfully", null));
    }

}
