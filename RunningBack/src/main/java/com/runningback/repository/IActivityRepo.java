package com.runningback.repository;

import com.runningback.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActivityRepo extends JpaRepository<Activity, Integer> {
}
