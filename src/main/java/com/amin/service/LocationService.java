package com.amin.service;

import com.amin.domain.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends CrudService<Location, Long> {
    public LocationService(CrudRepository<Location, Long> repository) {
        super(repository);
    }
}
