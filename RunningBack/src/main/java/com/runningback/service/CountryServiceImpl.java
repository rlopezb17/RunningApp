package com.runningback.service;

import com.runningback.dto.CountryDto;
import com.runningback.entity.Country;
import com.runningback.repository.ICountryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    private final ICountryRepo countryRepo;

    public CountryServiceImpl(ICountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }


    @Override
    public List<Country> getCountries() {
        return countryRepo.findAll();
    }
}
