package com.amin.controller.normal;

import com.amin.entity.Employee;
import com.amin.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.*;

import java.lang.String;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeNormalController {
    EmployeeService employeeService;

    public EmployeeNormalController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String list(Model model){
        List<com.amin.entity.Employee> employeeList=employeeService.findAll();
        model.addAttribute("employees",employeeList);
        return "employee/list-employee";
    }
    @GetMapping("/add")
    public String addEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee", employee);
        return "employee/add-employee";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
       return "redirect:/employee/list";
    }
    @GetMapping("/update")
    public String updateEmployee(@RequestParam ("employeeId")int id,Model model){
        Optional <Employee> employee=employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "employee/employee-form";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam ("employeeId")int id){
        employeeService.deleteById(id);
        return "redirect:/employee/list";
    }
}
