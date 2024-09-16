package com.runningback.service;

import com.runningback.dto.CountryDto;
import com.runningback.entity.Country;
import com.runningback.mapper.CountryMapper;
import com.runningback.repository.ICountryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements ICountryService {

    private final ICountryRepo countryRepo;

    public CountryServiceImpl(ICountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }


    @Override
    public List<CountryDto> getAllCountries() {
        List<Country> countries = countryRepo.findAll();
        return countries.stream()
                .map(CountryMapper::toCountryDto)
                .collect(Collectors.toList());
    }


}
