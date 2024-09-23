package com.runningback.controller;

import com.runningback.dto.CountryDto;
import com.runningback.dto.EffortDto;
import com.runningback.dto.TypeDto;
import com.runningback.entity.Country;
import com.runningback.entity.Effort;
import com.runningback.entity.Type;
import com.runningback.mapper.CountryMapper;
import com.runningback.mapper.EffortMapper;
import com.runningback.mapper.TypeMapper;
import com.runningback.service.ICountryService;
import com.runningback.service.IEffortService;
import com.runningback.service.ITypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/get")
public class GetsController {

    private final ICountryService countryService;
    private final IEffortService effortService;
    private final ITypeService typeService;

    public GetsController(ICountryService countryService, IEffortService effortService, ITypeService typeService) {
        this.countryService = countryService;
        this.effortService = effortService;
        this.typeService = typeService;
    }


    @GetMapping("/countries")
    public ResponseEntity<List<CountryDto>> getCountries() {
        List<Country> countries = countryService.getCountries();
        List<CountryDto> countriesDto = countries.stream()
                .map(CountryMapper::toCountryDto)
                .toList();

        return ResponseEntity.ok(countriesDto);
    }

    @GetMapping("/efforts")
    public ResponseEntity<List<EffortDto>> getEfforts() {
        List<Effort> efforts = effortService.getEfforts();
        List<EffortDto> effortDto = efforts.stream()
                .map(EffortMapper::toEffortDto)
                .toList();

        return ResponseEntity.ok(effortDto);
    }

    @GetMapping("/types")
    public ResponseEntity<List<TypeDto>> getTypes() {
        List<Type> types = typeService.getTypes();
        List<TypeDto> typeDto = types.stream()
                .map(TypeMapper::toTypeDto)
                .toList();

        return ResponseEntity.ok(typeDto);
    }

}
