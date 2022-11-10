package com.amin.service;

import com.amin.domain.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public List<Country> findAll();

    public Optional<Country> findById(Long id);

    public void save(Country country);

    public void deleteById(Long id);
}
