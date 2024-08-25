package com.amin.controller.normal;

import com.amin.controller.mapper.CountryMapper;
import com.amin.domain.entity.Country;
import com.amin.service.CountryService;
import com.amin.service.DTO.CountryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/country")
public class CountryNormalController {
    private final CountryService countryService;
    private final CountryMapper countryMapper;

    @GetMapping("/list")
    public String list(Model model) {
        List<Country> countryList = countryService.findAll();
        model.addAttribute("countries", countryMapper.fromCountryListToCountryDtoList(countryList));
        return "country/list-country";
    }

    @GetMapping("/add")
    public String addCountry(Model model) {
        model.addAttribute("country", countryMapper.fromCountryToCountryDto(new Country()));
        return "country/add-country";
    }

    @PostMapping("/save")
    public String saveCountry(@ModelAttribute("country") CountryDto country) {
        countryService.save(countryMapper.fromCountryDtoToCountry(country));
        return "redirect:/country/list";
    }

    @GetMapping("/update/{countryId}")
    public String updateCountry(@PathVariable("countryId") Long id, Model model) {
        Country country = countryService.findById(id);
        model.addAttribute("country", countryMapper.fromCountryToCountryDto(country));
        return "country/country-form";
    }

    @GetMapping("/delete/{countryId}")
    public String deleteCountry(@PathVariable("countryId") Long id) {
        countryService.deleteById(id);
        return "redirect:/country/list";
    }
}
