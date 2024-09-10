package com.runningback.service;

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
    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }


}
