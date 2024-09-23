package com.runningback.repository;

import com.runningback.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoesRepo extends JpaRepository<Shoes, Integer> {
}
