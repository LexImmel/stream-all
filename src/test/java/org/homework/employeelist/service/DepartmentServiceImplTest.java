package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Mock
    private EmployeeServiceMapImpl employeeService;
    private final Employee EMP1 = new Employee("David", "Brajka", 20000, 1);
    private final Employee EMP2 = new Employee("Prohor", "Zvyagin", 15000, 1);
    private final Employee EMP3 = new Employee("Fedor", "Mokhnow", 17000, 2);
    private final Employee EMP4 = new Employee("Maxim", "Rjanoy", 60000, 3);

    @BeforeEach
    void setUp() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(EMP1,EMP2,EMP3,EMP4));
    }

    @Test
    void sumSalaryByDepartment() {
        assertEquals(35000, departmentService.sumSalaryByDepartment(1));
    }

    @Test
    void maxSalaryByDepartment() {
        assertEquals(20000, departmentService.maxSalaryByDepartment(1));
    }

    @Test
    void minSalaryByDepartment() {
        assertEquals(15000, departmentService.minSalaryByDepartment(1));
    }

    @Test
    void getByDepartment() {
        List<Employee> employees = departmentService.getByDepartment(1);
        assertEquals(2, employees.size());
        assertTrue(employees.containsAll(Arrays.asList(EMP1,EMP2)));
    }

    @Test
    void getEmployeesByDepartment() {
        Map<Integer, List<Employee>> getAllEmployees = departmentService.getEmployeesByDepartment();
        assertEquals(3, getAllEmployees.size());
        assertEquals(2, getAllEmployees.get(1).size());
        assertTrue(getAllEmployees.get(3).contains(EMP4));
    }
}