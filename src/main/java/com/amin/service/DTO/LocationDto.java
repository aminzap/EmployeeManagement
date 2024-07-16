package com.amin.service.DTO;

import com.amin.domain.entity.Country;
import lombok.Data;

@Data
public class LocationDto {
    private Long id;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
    private CountryDto country;
}
