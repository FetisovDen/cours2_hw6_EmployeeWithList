package pro.sky.EmployeeWithList.Сoursework;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeWithList.exception.EmployeeAlreadyAddedException;
import pro.sky.EmployeeWithList.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;;

@Service
public class EmployeeService {
    static List<Employee> employeesBook = new ArrayList<>(List.of());

    public static String addEmployee(String firstName, String lastName) {
        if (employeesBook.contains(new Employee(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employeesBook.add(new Employee(firstName, lastName));
            return employeesBook.toString();
        }
    }
    public static String removeEmployee(String firstName, String lastName) {
        if (employeesBook.contains(new Employee(firstName, lastName))) {
            employeesBook.remove(new Employee(firstName, lastName));
            return employeesBook.toString();
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    public static String containsEmployee(String firstName, String lastName) {
        if (employeesBook.contains(new Employee(firstName, lastName))) {
            return employeesBook.toString();
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    public String findAll() {
        return employeesBook.toString();
    }


}




