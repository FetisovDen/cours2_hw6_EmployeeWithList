package pro.sky.EmployeeWithList.Сoursework;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeWithList.exception.EmployeeAlreadyAddedException;
import pro.sky.EmployeeWithList.exception.EmployeeNotFoundException;


import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    public static Map<String, Employee> employeesBook = new HashMap<>();

    private String id(Employee employee) {
        return employee.getFullName();
    }

    public static String addEmployee(String id, String fullName, double salary, int department) {
        if (!employeesBook.containsKey(id)) {
            employeesBook.put(id, new Employee(fullName, salary, department));
            return employeesBook.toString();
        } else {
            throw new EmployeeAlreadyAddedException();
        }
    }

    public static String removeEmployee(String id) {
        if (employeesBook.containsKey(id)) {
            employeesBook.remove(id);
            return employeesBook.toString();
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public static String containsEmployee(String id) {
        if (employeesBook.containsKey(id)) {
            return String.valueOf(employeesBook.get(id));
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public static String findAll() {

        return employeesBook.toString();
    }


}




