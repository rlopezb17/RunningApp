package com.runningback.service;

import com.runningback.entity.Shoes;
import com.runningback.repository.IShoesRepo;

import java.util.List;

public class ShoesServiceImpl implements IShoesService {

    private final IShoesRepo shoesRepo;

    public ShoesServiceImpl(IShoesRepo shoesRepo) {
        this.shoesRepo = shoesRepo;
    }

    @Override
    public void addShoes(Shoes shoes) {
        shoesRepo.save(shoes);
    }

    @Override
    public List<Shoes> getShoes() {
        return shoesRepo.findAll();
    }
}
