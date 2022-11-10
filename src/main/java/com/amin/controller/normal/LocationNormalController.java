package com.amin.controller.normal;

import com.amin.domain.entity.Location;
import com.amin.service.LocationService;
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
public class LocationNormalController {
    LocationService locationService;

    public LocationNormalController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/list")
    public String locationList(Model model) {
        List<Location> locationList = locationService.findAll();
        model.addAttribute("locations", locationList);
        return "location/list-location";
    }

    @GetMapping("/add")
    public String addLocation(Model model) {
        model.addAttribute("location", new Location());
        return "/location/add-location";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute("location") Location location) {
        locationService.save(location);
        return "redirect:/location/list";
    }

    @GetMapping("/update")
    public String updateLocation(@RequestParam("locationId") int id, Model model) {
        Optional<Location> location = locationService.findById(id);
        model.addAttribute("location", location);
        return "location/location-form";
    }

    @GetMapping("/delete")
    public String deleteLocation(@RequestParam("locationId") int id) {
        locationService.deleteById(id);
        return "redirect:/location/list";
    }
}
