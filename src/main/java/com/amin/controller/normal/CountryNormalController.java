package com.amin.controller.normal;

import com.amin.domain.entity.Country;
import com.amin.service.CountryService;
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
@RequestMapping("/country")
public class CountryNormalController {
    CountryService countryService;

    public CountryNormalController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);
        return "country/list-country";
    }

    @GetMapping("/add")
    public String addCountry(Model model) {
        model.addAttribute("country", new Country());
        return "country/add-country";
    }

    @PostMapping("/save")
    public String saveCountry(@ModelAttribute("country") Country country) {
        countryService.save(country);
        return "redirect:/country/list";
    }

    @GetMapping("/update")
    public String updateCountry(@RequestParam("countryId") Long id, Model model) {
        Optional<Country> country = countryService.findById(id);
        model.addAttribute("country", country);
        return "country/country-form";
    }

    @GetMapping("/delete")
    public String deleteCountry(@RequestParam("countryId") Long id) {
        countryService.deleteById(id);
        return "redirect:/country/list";
    }
}
