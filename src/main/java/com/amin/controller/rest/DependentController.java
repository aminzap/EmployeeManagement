package com.amin.controller.rest;


import com.amin.domain.entity.Dependent;
import com.amin.service.DependentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class DependentController {
    private final DependentService dependentService;
    @GetMapping(value = "/dependent")
    public ResponseEntity<List<Dependent>> findAll() {
        List<Dependent> dependentList = dependentService.findAll();
        return ResponseEntity.ok(dependentList);
    }

    @GetMapping(value = "/dependent/{dependentId}")
    public ResponseEntity<Dependent> findById(@PathVariable Long dependentId) {
        Dependent dependent = dependentService.findById(dependentId);
        return ResponseEntity.ok(dependent);
    }

    @PostMapping(value = "/dependent")
    public ResponseEntity<Dependent> save(@RequestBody Dependent dependent) {
        dependent = dependentService.save(dependent);
        return ResponseEntity.ok(dependent);
    }

    @PutMapping(value = "/dependent")
    public ResponseEntity<Dependent> updateDependent(@RequestBody Dependent dependent) {
        dependent = dependentService.save(dependent);
        return ResponseEntity.ok(dependent);
    }

    @DeleteMapping(value = "/dependent/{dependentId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long dependentId) {
            dependentService.deleteById(dependentId);
            return ResponseEntity.noContent().build();

    }
}
