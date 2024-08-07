package com.amin.service;

import com.amin.domain.entity.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    public List<Location> findAll();

    public Optional<Location> findById(Long id);

    public void save(Location location);

    public void deleteById(Long id);
}
