package com.runningback.service;

import com.runningback.entity.Effort;
import com.runningback.repository.IEffortRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
