package com.amin.controller.normal;

import com.amin.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.amin.service.CountryService;
import com.amin.entity.Country;
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
    public String list(Model model){
        List<Country>countries =countryService.findAll();
        model.addAttribute("countries",countries);
        return "country/list-country";
    }
    @GetMapping("/add")
    public String addCountry(Model model){
        Country country=new Country();
        model.addAttribute("country", country);
        return "country/add-country";
    }
    @PostMapping("/save")
    public String saveCountry(@ModelAttribute("country") Country country){
        countryService.save(country);
        return "redirect:/country/list";
    }
    @GetMapping("/update")
    public String updateCountry(@RequestParam("countryId")int id, Model model){
        Optional<Country> country=countryService.findById(id);
        model.addAttribute("country",country);
        return "country/country-form";
    }
    @GetMapping("/delete")
    public String deleteCountry(@RequestParam ("countryId")int id){
        countryService.deleteById(id);
        return "redirect:/country/list";
    }
}
