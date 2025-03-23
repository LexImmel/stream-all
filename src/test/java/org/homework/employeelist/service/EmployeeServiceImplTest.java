package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private EmployeeServiceMapImpl employeeService;
    private final Employee EMP = new Employee("David", "Brajka", 200000, 1);

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceMapImpl();

    }
    @Test
    void findEmployee() throws EmployeeNotFoundException {
        employeeService.addEmployee(EMP);
        assertEquals(EMP, employeeService.findEmployee(EMP.getName(), EMP.getSurname()));
    }

    @Test
    void getAllEmployees() {
        employeeService.addEmployee(EMP);
        employeeService.addEmployee(new Employee("Daaavid", "Braaajka"));
        assertEquals(2, employeeService.getAllEmployees().size());
    }

    @Test
    void add() {
        assertEquals(employeeService.getAllEmployees().size(), 0);
        employeeService.addEmployee(EMP);
        assertEquals(employeeService.getAllEmployees().size(), 1);
        assertTrue(employeeService.getAllEmployees().contains(EMP));
    }

    @Test
    void addSame() {
        employeeService.addEmployee(EMP);
        InvalidInputException e =
        assertThrows(InvalidInputException.class, () -> employeeService.addEmployee(EMP));
        assertEquals(e.getMessage(), "Employee Already Exists");
    }

    @Test
    void removeEmployee() {
        employeeService.addEmployee(EMP);
        assertEquals(employeeService.getAllEmployees().size(), 1);
        employeeService.removeEmployee(EMP);
        assertEquals(employeeService.getAllEmployees().size(), 0);
    }

    @Test
    void testAddEmployee() {
    }
}