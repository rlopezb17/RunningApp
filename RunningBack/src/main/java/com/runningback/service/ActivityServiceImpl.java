package com.runningback.service;

import com.runningback.entity.Activity;
import com.runningback.repository.IActivityRepo;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements IActivityService {

    private final IActivityRepo activityRepo;

    public ActivityServiceImpl(IActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }


    @Override
    public void addActivity(Activity activity) {
        activityRepo.save(activity);
    }

}
