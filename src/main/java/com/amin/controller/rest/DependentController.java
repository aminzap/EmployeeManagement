package com.amin.controller.rest;


import com.amin.domain.entity.Dependent;
import com.amin.service.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DependentController {
    DependentService dependentService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public DependentController(DependentService dependentService) {
        this.dependentService = dependentService;
    }

    @GetMapping(value = "/dependent")
    public List<Dependent> findAll() {
        return dependentService.findAll();
    }

    @GetMapping(value = "/dependent/{dependentId}")
    public Optional<Dependent> findById(@PathVariable int dependentId) {
        if (dependentService.findById(dependentId).isPresent()) {
            return dependentService.findById(dependentId);
        } else {
            throw new RuntimeException("This dependent id is not valid: " + dependentId);
        }
    }

    @PostMapping(value = "/dependent")
    public Dependent save(@RequestBody Dependent dependent) {
        dependentService.save(dependent);
        return dependent;
    }

    @PutMapping(value = "/dependent")
    public Dependent updateDependent(@RequestBody Dependent dependent) {
        dependentService.save(dependent);
        return dependent;
    }

    @DeleteMapping(value = "/dependent/{dependentId}")
    public String deleteById(@PathVariable int dependentId) {
        if (dependentService.findById(dependentId).isPresent()) {
            dependentService.deleteById(dependentId);
            return "Delete dependent " + dependentId + " successfully";
        } else {
            throw new RuntimeException("This dependent id is not valid: " + dependentId);
        }
    }
}
