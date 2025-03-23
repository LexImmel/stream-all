package org.homework.employeelist.service.api;

import org.homework.employeelist.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {

    Double sumSalaryByDepartment(int departmentId);

    Double maxSalaryByDepartment(int departmentId);

    Double minSalaryByDepartment(int departmentId) ;

   List<Employee> getByDepartment(int departmentId);

    Map<Integer, List<Employee>> getEmployeesByDepartment();


}
