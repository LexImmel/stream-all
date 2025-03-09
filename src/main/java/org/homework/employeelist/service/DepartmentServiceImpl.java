package org.homework.employeelist.service;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(@Qualifier("employeeServiceImpl") EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalaryByDepartment(Integer departmentId) throws EmployeeNotFoundException {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId()==departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("This employee does not exist"));
    }

    @Override
    public Employee minSalaryByDepartment(Integer departmentId) throws EmployeeNotFoundException {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId()==departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("This employee does not exist"));
    }

    @Override
    public List<Employee> getByDepartment(Integer departmentId){
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId()==departmentId)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartment(){
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

}
