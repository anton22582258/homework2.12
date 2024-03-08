package com.example.mockito.homework22.demo;

import com.example.mockito.homework22.demo.Employee;
import com.example.mockito.homework22.demo.exception.EmployeeAlreadyAddedException;
import com.example.mockito.homework22.demo.service.EmployeeService;
import com.example.mockito.homework22.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceTest {
    EmployeeServiceImpl service = new EmployeeServiceImpl();

    @Test
    void add_possitive() {
        Employee employee = new Employee("Ivan", "Ivanov", 10000, 1);
        service.add(employee);
        Collection<Employee> actual = service.getAll();
        assertEquals(1, actual.size());
        Employee actualEmployee = actual.iterator().next();
        assertEquals(employee.getFirstName(), actualEmployee.getFirstName());
        assertEquals(employee.getLastName(), actualEmployee.getLastName());
    }

    @Test
    void add_negative_unique() {
        Employee employee = new Employee("Ivan", "Ivanov", 10000, 1);
        service.add(employee);
        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            service.add(employee);
        });

    }

    @Test
    void find() {
        Employee employee = new Employee("Oleg", "Popov", 10000, 1);
        service.add(employee);
        Employee actual = service.find("Oleg", "Popov");
        assertEquals(employee.getFirstName(), actual.getFirstName());
        assertEquals(employee.getLastName(), actual.getLastName());

    }

    @Test
    void remove() {
        Employee employee = new Employee("Oleg", "Petrov", 10000, 1);
        service.add(employee);
        assertEquals(1, service.getAll().size());
        service.remove("Oleg", "Petrov");
        assertEquals(0, service.getAll().size());

    }
}
