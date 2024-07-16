package com.amin.controller.mapper;

import com.amin.domain.entity.Country;
import com.amin.service.DTO.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {
    CountryDto fromCountryToCountryDto(Country country);

    List<CountryDto> fromCountryListToCountryDtoList(List<Country> country);

    Country fromCountryDtoToCountry(CountryDto countryDto);


}
