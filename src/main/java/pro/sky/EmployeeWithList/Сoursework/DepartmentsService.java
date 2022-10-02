package pro.sky.EmployeeWithList.Сoursework;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static pro.sky.EmployeeWithList.Сoursework.EmployeeService.employeesBook;


@Service
public class DepartmentsService {
    private final EmployeeService employeeService;

    public DepartmentsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Optional<Employee> maxSalaryByDepartment(Integer department) {
        return employeesBook.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(employee -> employee.getSalary()));
    }


    public Optional<Employee> minSalaryByDepartment(Integer department) {
        return employeesBook.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(employee -> employee.getSalary()));
    }

    public List<Employee> allOfDepartment(Integer department) {
        return employeesBook.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public List<String> sortedByDepartment() {
        return employeesBook.values().stream()
                .sorted(Comparator.comparingInt(employee -> employee.getDepartment()))
                .map(e -> "[" + e + "]")
                .collect(Collectors.toList());

    }
}










