package com.amin.service;

import com.amin.entity.Location;
import com.amin.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImp implements LocationService{
    LocationRepository locationRepository;

    public LocationServiceImp(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(int id) {
        if (locationRepository.findById(id).isPresent()){
          return locationRepository.findById(id);
        }else {
            throw new RuntimeException("This id is not valid for finding: "+id);
        }
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void deleteById(int id) {
        if (locationRepository.findById(id).isPresent()){
            locationRepository.deleteById(id);
        }else {
            throw new RuntimeException("This id is not valid for deleting: "+id);
        }
    }
}
