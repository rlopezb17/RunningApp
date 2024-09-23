package com.runningback.service;

import com.runningback.entity.Shoes;
import com.runningback.repository.IShoesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
