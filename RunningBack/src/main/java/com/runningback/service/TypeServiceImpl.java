package com.runningback.service;

import com.runningback.entity.Type;
import com.runningback.repository.ITypeRepo;

import java.util.List;

public class TypeServiceImpl implements ITypeService {

    private final ITypeRepo typeRepo;


    public TypeServiceImpl(ITypeRepo typeRepo) {
        this.typeRepo = typeRepo;
    }

    @Override
    public List<Type> getTypes() {
        return typeRepo.findAll();
    }
}
