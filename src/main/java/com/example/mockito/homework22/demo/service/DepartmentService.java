package com.example.mockito.homework22.demo.service;

import com.example.mockito.homework22.demo.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    double getEmployeeMinSalary(int department);

    double getEmployeeMaxSalary(int department);

    List<Employee> getAll(int department);

    Map<Integer, List<Employee>> getAll();

    double getEmployeesSalarySum(int department);
}

