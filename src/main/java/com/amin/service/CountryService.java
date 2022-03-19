package com.amin.service;

import com.amin.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public List<Country> findAll();
    public Optional<Country> findById(int id);
    public void save(Country country);
    public void deleteById(int id);
}
