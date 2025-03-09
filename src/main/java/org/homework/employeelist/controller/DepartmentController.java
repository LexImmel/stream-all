package org.homework.employeelist.controller;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }



   @GetMapping("/max-salary")
   public Employee maxSalaryByDepartment(@RequestParam("departmentId") Integer departmentId) throws EmployeeNotFoundException {

       return departmentService.maxSalaryByDepartment(departmentId);
   }

   @GetMapping("/min-salary")
   public Employee minSalaryByDepartment(@RequestParam("departmentId") Integer departmentId) throws EmployeeNotFoundException {

      return departmentService.minSalaryByDepartment(departmentId);
  }

  @GetMapping("/all")
    public Map<Integer, java.util.List<Employee>> getEmployeesByDepartment(){
return departmentService.getEmployeesByDepartment();
  }
}