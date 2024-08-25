package com.amin.controller.normal;

import com.amin.controller.mapper.CountryMapper;
import com.amin.controller.mapper.LocationMapper;
import com.amin.domain.entity.Location;
import com.amin.service.CountryService;
import com.amin.service.DTO.LocationDto;
import com.amin.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/location")
@AllArgsConstructor
public class LocationNormalController {
    private final LocationService locationService;
    private final CountryService countryService;
    private final CountryMapper countryMapper;
    private final LocationMapper locationMapper;


    @GetMapping("/list")
    public String locationList(Model model) {
        List<Location> locationList = locationService.findAll();
        model.addAttribute("locations", locationList);
        return "location/list-location";
    }

    @GetMapping("/add")
    public String addLocation(Model model) {
        model.addAttribute("location", new Location());
        model.addAttribute("countryList", countryMapper.fromCountryListToCountryDtoList(countryService.findAll()));
        return "/location/add-location";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute("location") LocationDto locationDto) {
        locationService.save(locationMapper.fromLocationDtoToLocation(locationDto));
        return "redirect:/location/list";
    }

    @GetMapping("/update")
    public String updateLocation(@RequestParam("locationId") Long id, Model model) {
        Location location = locationService.findById(id);
        model.addAttribute("location", location);
        return "location/location-form";
    }

    @GetMapping("/delete")
    public String deleteLocation(@RequestParam("locationId") Long id) {
        locationService.deleteById(id);
        return "redirect:/location/list";
    }
}
