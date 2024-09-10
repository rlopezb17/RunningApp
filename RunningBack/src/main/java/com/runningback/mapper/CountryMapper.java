package com.runningback.mapper;

import com.runningback.dto.CountryDto;
import com.runningback.entity.Country;

public class CountryMapper {

    public static CountryDto toCountryDto(Country country) {
        CountryDto dto = new CountryDto();
        dto.setId(country.getId());
        dto.setCode(country.getCode());
        dto.setName(country.getName());
        dto.setIcon(country.getIcon());
        return dto;
    }

    public static Country toCountryEntity(CountryDto dto) {
        Country country = new Country();
        country.setId(dto.getId());
        country.setCode(dto.getCode());
        country.setName(dto.getName());
        country.setIcon(dto.getIcon());
        return country;
    }

}
