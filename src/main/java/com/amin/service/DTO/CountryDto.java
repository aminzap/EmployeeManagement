package com.amin.service.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryDto implements Serializable {
    private Long id;
    private String countryName;
}
