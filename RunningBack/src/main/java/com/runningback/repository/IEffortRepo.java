package com.runningback.repository;

import com.runningback.entity.Effort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEffortRepo extends JpaRepository<Effort, Integer> {
}
