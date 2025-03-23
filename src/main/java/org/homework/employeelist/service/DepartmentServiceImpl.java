package org.homework.employeelist.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.service.api.DepartmentService;
import org.homework.employeelist.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(@Qualifier("employeeServiceMapImpl") EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @Override
    public Double sumSalaryByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public Double maxSalaryByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId)
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
    }

    @Override
    public Double minSalaryByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId)
                .mapToDouble(Employee::getSalary)
                .min()
                .orElseThrow(() -> new EmployeeNotFoundException("This department does not exist"));
    }

    @Override
    public List<Employee> getByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartment() {
        return employeeService.getAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

    private Stream<Employee> getEmployeesByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(it -> it.getDepartmentId() == departmentId);
    }
}
