package com.runningback.service;

import com.runningback.dto.CountryDto;
import com.runningback.entity.Country;

import java.util.List;

public interface ICountryService {

    List<CountryDto> getAllCountries();

}
