package com.amin.service;

import com.amin.domain.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends CrudService<Country, Long> {
    public CountryService(CrudRepository<Country, Long> repository) {
        super(repository);
    }
}
