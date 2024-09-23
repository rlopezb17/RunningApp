package com.runningback.repository;

import com.runningback.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepo extends JpaRepository<Type, Integer> {
}
