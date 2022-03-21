package com.amin.controller.rest;


import com.amin.entity.Location;
import com.amin.service.LocationService;
import org.springframework.web.bind.annotation.*;

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
    public List<Location>findAll(){
        return locationService.findAll();
    }

    @GetMapping(value = "/location/{locationId}")
    public Optional<Location> findById(@PathVariable int locationId){
        if (locationService.findById(locationId).isPresent()){
            return locationService.findById(locationId);
        }else {
            throw new RuntimeException("This location id is not valid");
        }
    }
    @PostMapping(value = "/location")
    public Location save (@RequestBody Location location){
        location.setLocationId(0);
        locationService.save(location);
        return location;
    }
    @PutMapping(value = "/location")
    public Location updateLocation(@RequestBody Location location){
        locationService.save(location);
        return location;
    }
    @DeleteMapping(value = "/location/{locationId}")
    public String deleteById(@PathVariable int locationId){
        if (locationService.findById(locationId).isPresent()){
            locationService.deleteById(locationId);
            return "This location is deleted successfully by id: "+locationId;
        }else {
            throw new RuntimeException("This location id is not valid for deleting: "+locationId);
        }
    }
}
