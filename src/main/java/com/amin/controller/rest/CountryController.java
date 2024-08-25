package com.amin.controller.rest;


import com.amin.domain.entity.Country;
import com.amin.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping(value = "/country")
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping(value = "/country/{countryId}")
    public ResponseEntity<Country> findById(@PathVariable Long countryId) {
        Country country = countryService.findById(countryId);
        return ResponseEntity.ok(country);
    }

    @PostMapping(value = "/country")
    public Country save(@RequestBody Country country) {
        countryService.save(country);
        return country;
    }

    @PutMapping(value = "/country")
    public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
        country = countryService.save(country);
        return ResponseEntity.ok(country);
    }

    @RequestMapping(value = "/country/{countryId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long countryId) {
        countryService.deleteById(countryId);
        return ResponseEntity.noContent().build();
    }
}
