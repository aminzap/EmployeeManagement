package com.amin.controller.mapper;

import com.amin.domain.entity.Location;
import com.amin.service.DTO.LocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CountryMapper.class)
public interface LocationMapper {
    Location fromLocationDtoToLocation(LocationDto locationDto);

    LocationDto fromLocationToLocationDto(Location location);

    List<Location> fromLocationListToLocationDtoList(List<LocationDto> locationDto);

}
