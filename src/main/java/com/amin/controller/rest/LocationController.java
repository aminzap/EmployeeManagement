package com.amin.controller.rest;


import com.amin.domain.entity.Location;
import com.amin.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;


    @GetMapping(value = "/location")
    public ResponseEntity<List> findAll() {
        List<Location> locationList = locationService.findAll();
        return ResponseEntity.ok(locationList);
    }

    @GetMapping(value = "/location/{locationId}")
    public ResponseEntity<Location> findById(@PathVariable Long locationId) {
        Location location = locationService.findById(locationId);
        return ResponseEntity.ok(location);
    }

    @PostMapping(value = "/location")
    public ResponseEntity<Location> save(@RequestBody Location location) {
        locationService.save(location);
        return ResponseEntity.ok(location);
    }

    @PutMapping(value = "/location")
    public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
        locationService.save(location);
        return ResponseEntity.ok(location);
    }

    @DeleteMapping(value = "/location/{locationId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long locationId) {
        locationService.deleteById(locationId);
        return ResponseEntity.noContent().build();
    }
}
