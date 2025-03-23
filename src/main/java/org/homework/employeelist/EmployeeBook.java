package org.homework.employeelist;

import org.homework.employeelist.Employee;

public class EmployeeBook {

    private final Employee[] emp;

    public EmployeeBook(int size) {
        emp = new Employee[size];
    }

    public int size() {
        int size = 0;
        for (Employee employee : emp) {
            size++;
        }
        return size;
    }

    //Показать все данные сотрудников компании:
    public void printAllEmployees() {
        for (Employee employee : emp) {
            System.out.println(employee);
        }
    }

    //Показать данные по департаменту
    public void printDeptEmployees(int dept) {
        System.out.println("Отдел номер " + dept + ":");
        for (Employee employee : emp) {
            if (employee.getDepartmentId() == dept) {
                System.out.println(" ФИО сотрудника: " + employee.getFullName() + " Зарплата: " + employee.getSalary() + " Id: " + employee.getDepartmentId());
            }
        }
    }

    //Подсчет общей суммы зарплат
    public int calculateSumSalary() {
        int total = 0;
        for (Employee employee : emp) {
            total += (Double) employee.getSalary();
        }
        return total;
    }

    //Вывод минимальной и максимальной зарплат
    public Employee findEmployeeMinSalary() {
        if (emp.length == 0) return null;
        Employee minSalaryEmployee = emp[0];
        for (int i = 1; i < emp.length; i++) {
            if (emp[i].getSalary() < minSalaryEmployee.getSalary()) minSalaryEmployee = emp[i];
        }
        return minSalaryEmployee;
    }

    public Employee findEmployeeMaxSalary() {
        if (emp.length == 0) return null;
        Employee maxSalaryEmployee = emp[0];
        for (int i = 1; i < emp.length; i++) {
            if (emp[i].getSalary() > maxSalaryEmployee.getSalary()) maxSalaryEmployee = emp[i];
        }
        return maxSalaryEmployee;
    }

    //Вывод средней зарплаты
    public double calculateAvgSalary() {
        if (emp.length == 0) return 0;
        return (double) calculateSumSalary() / emp.length;
    }

    //Вывод ФИО всех сотрудников
    public void printEmployeeFullNames() {
        for (Employee employee : emp) {
            System.out.println(employee.getFullName());
        }
    }

    //////////////////////////////////////////////////////////////////////////
    //Индексация зарплаты на фиксированный процент
    public void countIndexedSalary(int percent) {
        for (Employee employee : emp) {
            double currentSalary = employee.getSalary();
            employee.setSalary((Double) (currentSalary * (percent / 100f + 1)));
        }
    }

    //Зп отдела
    public int salaryOfDept(int dept) {
        int sum = 0;
        for (Employee employee : emp) {
            if (employee.getDepartmentId() == dept) {
                sum += (Double) employee.getSalary();
            }
        }
        return sum;
    }

    public int deptEmployeeCount(int dept) {
        int count = 0;
        for (Employee employee : emp) {
            if (employee.getDepartmentId() == dept) {
                count++;
            }
        }
        return count;
    }

    public int deptAvgSalary(int dept) {
        return salaryOfDept(dept) / deptEmployeeCount(dept);
    }

    //Мин зп в отделе
    public int minSalaryOfDept(int dept) {
        double minSalaryDept = emp[0].getSalary();
        for (Employee employee : emp) {
            if (employee.getDepartmentId() != dept) {
                continue;
            }
            if (employee.getSalary() < minSalaryDept) {
                minSalaryDept = employee.getSalary();
            }
        }
        return (int) minSalaryDept;
    }

    //Макс зп в отделе
    public int maxSalaryOfDept(int dept) {
        double maxSalaryDept = emp[0].getSalary();
        for (Employee employee : emp) {
            if (employee.getDepartmentId() != dept) {
                continue;
            }
            if (employee.getSalary() > maxSalaryDept) {
                maxSalaryDept = employee.getSalary();
            }
        }
        return (int) maxSalaryDept;
    }

    //Проиндексированная зп в указанном отделе на указанный процент
    public void countIndSalaryDept(int dept, int percent) {
        for (Employee employee : emp) {
            double currentSalary = employee.getSalary();
            if (employee.getDepartmentId() == dept) {
                employee.setSalary((Double) (currentSalary * (percent / 100f + 1)));

            }
        }
    }

    public void salaryLesserThan(int lowestSalary) {
        for (Employee employee : emp) {
            if (employee.getSalary() < lowestSalary) {
                System.out.println(" ФИО сотрудника: " + employee.getFullName() + " Зарплата: " + employee.getSalary() + " Id: " + employee.getDepartmentId());
            }
        }
    }

    public void salaryHigherThan(int highestSalary) {
        for (Employee employee : emp) {
            if (employee.getSalary() >= highestSalary) {
                System.out.println(" ФИО сотрудника: " + employee.getFullName() + " Зарплата: " + employee.getSalary() + " Id: " + employee.getDepartmentId());
            }
        }
    }

    public Employee[] getEmployees() {
        return new Employee[0];
    }

    public void deleteEmployee(int index) {
        emp[index] = null;
    }

    public void getEmployeeFromId(int setId) {
        for (Employee employee : emp) {
            if (employee.getDepartmentId() == setId) {
                System.out.println(employee);
            }
        }
    }

    public void addEmployee(Employee newEmployee) {
        boolean result = false;
        for (int i = 0; i < emp.length; i++) {
            if (emp[i] == null) {
                emp[i] = newEmployee;
                return;
            }
        }
    }
}
