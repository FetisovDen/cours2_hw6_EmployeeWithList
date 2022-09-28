package pro.sky.EmployeeWithList.Сoursework;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeWithList.exception.EmployeeAlreadyAddedException;
import pro.sky.EmployeeWithList.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;;

@Service
public class EmployeeService {
    static Map<Integer,Employee> employeesBook = new HashMap<>();

    public static String addEmployee(Integer id, String fullName) {
        if (!employeesBook.containsKey(id) && !employeesBook.containsValue(new Employee(fullName))) {
            employeesBook.put(id, new Employee(fullName));
            return employeesBook.toString();
        } else {
            throw new EmployeeAlreadyAddedException();
        }
    }
    public static String removeEmployee(Integer id) {
        if (employeesBook.containsKey(id)) {
            employeesBook.remove(id);
            return employeesBook.toString();
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    public static String containsEmployee(Integer id) {
        if (employeesBook.containsKey(id)) {
            return String.valueOf(employeesBook.get(id));
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    public String findAll() {
        return employeesBook.toString();
    }

}




