package com.amin.controller.normal;

import com.amin.domain.entity.Dependent;
import com.amin.service.DependentService;
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
@RequestMapping("/dependent")
public class DependentNormalController {
    DependentService dependentService;

    public DependentNormalController(DependentService dependentService) {
        this.dependentService = dependentService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Dependent> dependents = dependentService.findAll();
        model.addAttribute("dependents", dependents);
        return "dependent/list-dependent";
    }

    @GetMapping("/add")
    public String addDependent(Model model) {
        Dependent dependent = new Dependent();
        model.addAttribute("dependent", dependent);
        return "dependent/add-dependent";
    }

    @PostMapping("/save")
    public String saveDependent(@ModelAttribute("dependent") Dependent dependent) {
        dependentService.save(dependent);
        return "redirect:/dependent/list";
    }

    @GetMapping("/update")
    public String updateDependent(@RequestParam("dependentId") Long id, Model model) {
        Dependent dependent = dependentService.findById(id);
        model.addAttribute("dependent", dependent);
        return "dependent/dependent-form";
    }

    @GetMapping("/delete")
    public String deleteDependent(@RequestParam("dependentId") Long id) {
        dependentService.deleteById(id);
        return "redirect:/dependent/list";
    }
}
