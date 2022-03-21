package com.amin.controller.rest;


import com.amin.entity.Country;
import com.amin.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class CountryController {
    CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/country")
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping(value = "/country/{countryId}")
    public Optional<Country> findById(@PathVariable int countryId) {
        if (countryService.findById(countryId).isPresent()) {
            return countryService.findById(countryId);
        } else {
            throw new RuntimeException("This country id is not available" + countryId);
        }
    }

    @PostMapping(value = "/country")
    public Country save(@RequestBody Country country) {
        country.setCountryId(0);
        countryService.save(country);
        return country;
    }

    @PutMapping(value = "/country")
    public Country updateCountry(@RequestBody Country country) {
        countryService.save(country);
        return country;
    }

    @RequestMapping(value = "/country/{countryId}")
    public void deleteById(@PathVariable int countryId) {
        if (countryService.findById(countryId).isPresent()) {
            countryService.deleteById(countryId);
        } else {
            throw new RuntimeException("This country id is not valid: " + countryId);
        }
    }
}
