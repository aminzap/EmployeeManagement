package com.amin.controller.normal;
import com.amin.entity.Employee;
import com.amin.service.DepartmentService;
import com.amin.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.amin.entity.Department;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/department")
public class DepartmentNormalController {
    DepartmentService departmentService;

    public DepartmentNormalController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/list")
    public String list(Model model){
        List<Department> departments=departmentService.findAll();
        model.addAttribute("departments",departments);
        return "department/list-department";
    }
    @GetMapping("/add")
    public String addDepartment(Model model){
        Department department=new Department();
        model.addAttribute("department", department);
        return "department/add-department";
    }
    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") Department department){
        departmentService.save(department);
        return "redirect:/department/list";
    }
    @GetMapping("/update")
    public String updateDepartment(@RequestParam("departmentId")int id, Model model){
        Optional<Department> department=departmentService.findById(id);
        model.addAttribute("department",department);
        return "department/department-form";
    }
    @GetMapping("/delete")
    public String deleteDepartment(@RequestParam ("departmentId")int id){
        departmentService.deleteById(id);
        return "redirect:/department/list";
    }
}
