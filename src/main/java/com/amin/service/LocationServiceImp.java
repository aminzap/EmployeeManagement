package com.amin.service;

import com.amin.domain.entity.Location;
import com.amin.domain.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImp implements LocationService {
    LocationRepository locationRepository;

    @Autowired
    public LocationServiceImp(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        if (locationRepository.findById(id).isPresent()) {
            return locationRepository.findById(id);
        } else {
            throw new RuntimeException("This id is not valid for finding: " + id);
        }
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void deleteById(Long id) {
        if (locationRepository.findById(id).isPresent()) {
            locationRepository.deleteById(id);
        } else {
            throw new RuntimeException("This id is not valid for deleting: " + id);
        }
    }
}
