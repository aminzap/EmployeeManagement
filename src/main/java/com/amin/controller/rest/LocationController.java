package com.amin.controller.rest;


import com.amin.domain.entity.Location;
import com.amin.service.LocationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class LocationController {
    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(value = "/location")
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping(value = "/location/{locationId}")
    public Optional<Location> findById(@PathVariable Long locationId) {
        if (locationService.findById(locationId).isPresent()) {
            return locationService.findById(locationId);
        } else {
            throw new RuntimeException("This location id is not valid");
        }
    }

    @PostMapping(value = "/location")
    public Location save(@RequestBody Location location) {
        locationService.save(location);
        return location;
    }

    @PutMapping(value = "/location")
    public Location updateLocation(@RequestBody Location location) {
        locationService.save(location);
        return location;
    }

    @DeleteMapping(value = "/location/{locationId}")
    public String deleteById(@PathVariable Long locationId) {
        if (locationService.findById(locationId).isPresent()) {
            locationService.deleteById(locationId);
            return "This location is deleted successfully by id: " + locationId;
        } else {
            throw new RuntimeException("This location id is not valid for deleting: " + locationId);
        }
    }
}
