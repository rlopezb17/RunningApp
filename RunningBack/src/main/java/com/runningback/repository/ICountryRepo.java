package com.runningback.repository;

import com.runningback.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepo extends JpaRepository<Country, Integer> {
}
