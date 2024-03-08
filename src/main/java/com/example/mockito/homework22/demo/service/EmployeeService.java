package com.example.mockito.homework22.demo.service;

import com.example.mockito.homework22.demo.Employee;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface EmployeeService {
    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getAll();

    String createKey(Employee employee);

    String createKey(String firstName, String lastName);
}


