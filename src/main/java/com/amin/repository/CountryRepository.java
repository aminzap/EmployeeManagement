package com.amin.repository;

import com.amin.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country,Integer> {
}
