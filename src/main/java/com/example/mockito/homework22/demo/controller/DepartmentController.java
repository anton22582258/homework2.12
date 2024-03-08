package com.example.mockito.homework22.demo.controller;

import com.example.mockito.homework22.demo.service.DepartmentService;
import com.example.mockito.homework22.demo.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/sum")
    public double getEmployeesSalarySum(@PathVariable("id") int department) {
        return departmentService.getEmployeesSalarySum(department);
    }


    @GetMapping("/{id}/salary/max")
    public double getEmployeeMaxSalary(@PathVariable("id") int department) {
        return departmentService.getEmployeeMaxSalary(department);
    }

    @GetMapping("/{id}/salary/min")
    public double getEmployeeMinSalary(@PathVariable("id") int department) {
        return departmentService.getEmployeeMinSalary(department);
    }

    @GetMapping(value = "/{id}/employees")
    public List<Employee> getAll(@PathVariable("id") int department) {
        return departmentService.getAll(department);
    }

    @GetMapping("/employees")
    private Map<Integer, List<Employee>> getAll() {
        return departmentService.getAll();
    }
}
