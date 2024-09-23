package com.runningback.service;

import com.runningback.entity.Effort;
import com.runningback.repository.IEffortRepo;

import java.util.List;

public class EffortServiceImpl implements IEffortService {

    private final IEffortRepo effortRepo;

    public EffortServiceImpl(IEffortRepo effortRepo) {
        this.effortRepo = effortRepo;
    }


    @Override
    public List<Effort> getEfforts() {
        return effortRepo.findAll();
    }
}
