package com.amin.service;

import com.amin.domain.entity.Country;
import com.amin.domain.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryServiceImp implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        if (countryRepository.findById(id).isPresent()) {
            return countryRepository.findById(id);
        } else {
            throw new RuntimeException("This id is not valid for finding: " + id);
        }
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        if (countryRepository.findById(id).isPresent()) {
            countryRepository.deleteById(id);
        } else {
            throw new RuntimeException("This id is not valid for deleting " + id);
        }
    }
}
