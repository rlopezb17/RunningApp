package com.runningback.service;

import com.runningback.entity.Shoes;

import java.util.List;

public interface IShoesService {

    void addShoes(Shoes shoes);
    List<Shoes> getShoes();

}
