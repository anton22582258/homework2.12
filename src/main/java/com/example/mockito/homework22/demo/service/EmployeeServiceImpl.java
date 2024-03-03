package com.example.mockito.homework22.demo.service;

import com.example.mockito.homework22.demo.exception.EmployeeSttorageIsFullException;
import com.example.mockito.homework22.demo.exception.EmployeeNotFoundException;
import com.example.mockito.homework22.demo.Employee;
import com.example.mockito.homework22.demo.exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int SIZE_LIMIT = 7;
    private final Map<String, Employee> employees = new HashMap<>(SIZE_LIMIT);

    public EmployeeServiceImpl() {
    }


    public Employee add(Employee employee) {

        if (employees.containsKey(createKey(employee))) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        if (employees.size() >= SIZE_LIMIT) {
            throw new EmployeeSttorageIsFullException();
        }
        employees.put(createKey(employee), employee);
        return employee;
    }


    public Employee remove(String firstName, String lastName) {
        return employees.remove(createKey(firstName, lastName));
    }


    public Employee find(String firstName, String lastName) {
        Employee employee = employees.get(createKey(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    public Collection<Employee> getAll() {
        return employees.values();
    }

    public String createKey(Employee employee) {
        return createKey(employee.getFirstName(), employee.getLastName());
    }

    public String createKey(String firstName, String lastName) {
        return (firstName + lastName).toLowerCase();
    }

}