package com.amin.service;

import com.amin.domain.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    void save(Country country);

    void deleteById(Long id);
}
