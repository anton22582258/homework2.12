package com.example.mockito.homework22.demo;

import com.example.mockito.homework22.demo.exception.EmployeeNotFoundException;
import com.example.mockito.homework22.demo.service.DepartmentService;
import com.example.mockito.homework22.demo.service.DepartmentServiceImpl;
import com.example.mockito.homework22.demo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentServiceImpl departmentService;

    @BeforeEach
    void init() {
        when(employeeService.getAll()).thenReturn(List.of(new Employee("Ivan", "Petrov", 10000, 1), new Employee("Ivan", "Popov", 15000, 1), new Employee("Oleg", "Petrov", 20000, 2), new Employee("Oleg", "Popov", 15000, 2), new Employee("Inna", "Petrova", 25000, 2), new Employee("Yury", "Semenovv", 10000, 3), new Employee("Anna", "Glebova", 30000, 3)));
    }

    @Test
    void sum() {
        assertEquals(25000, departmentService.getEmployeesSalarySum(1));
        assertEquals(60000, departmentService.getEmployeesSalarySum(2));
    }

    @Test
    void max() {
        assertEquals(15000, departmentService.getEmployeeMaxSalary(1));
        assertEquals(25000, departmentService.getEmployeeMaxSalary(2));
    }

    @Test
    void min() {
        assertEquals(10000, departmentService.getEmployeeMinSalary(1));
        assertEquals(15000, departmentService.getEmployeeMinSalary(2));
    }

    @Test
    void filter_by_department() {
        List<Employee> actual = departmentService.getAll(1);
        for (Employee employee : actual) {
            assertEquals(1, employee.getDepartment());
        }
    }

    @Test
    void get_grouped() {
        Map<Integer, List<Employee>> actual = departmentService.getAll();
        assertEquals(3, actual.keySet().size());
        assertTrue(actual.keySet().contains(1));
        assertTrue(actual.keySet().contains(2));
        assertEquals(2, actual.get(1).size());
        assertEquals(3, actual.get(2).size());
    }

    @Test
    void max_negative() {
        assertThrows(EmployeeNotFoundException.class, () -> {
            departmentService.getEmployeeMaxSalary(4);
        });
    }


    @Test
    void employeeMaxSalaryDepartmentNoSuchElement() {
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.getEmployeeMaxSalary(1000));
    }

    @Test
    void employeeMinSalaryWithDepartment() {
        assertEquals(15000, departmentService.getEmployeeMinSalary(2));
    }

    @Test
    void employeeSumSalaryDepartmentNoSuchElement() {
        assertEquals(25000, departmentService.getEmployeesSalarySum(1));
    }


}









