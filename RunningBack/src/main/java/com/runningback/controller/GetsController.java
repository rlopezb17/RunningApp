package com.runningback.controller;

import com.runningback.dto.CountryDto;
import com.runningback.service.ICountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/get")
public class GetsController {

    private final ICountryService countryService;

    public GetsController(ICountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/countries")
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        List<CountryDto> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

}
