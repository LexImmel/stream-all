package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeAlreadyAddedException;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {

    Employee maxSalaryByDepartment(Integer departmentId) throws EmployeeNotFoundException;

    Employee minSalaryByDepartment(Integer departmentId) throws EmployeeNotFoundException;

   List<Employee> getByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> getEmployeesByDepartment();
}
