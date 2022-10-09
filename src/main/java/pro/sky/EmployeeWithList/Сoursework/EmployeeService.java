package pro.sky.EmployeeWithList.Сoursework;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.EmployeeWithList.exception.BadRequestException;
import pro.sky.EmployeeWithList.exception.EmployeeAlreadyAddedException;
import pro.sky.EmployeeWithList.exception.EmployeeNotFoundException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    public final Map<String , Employee> employeesBook = new HashMap<>();

    private  String key(String fullname) {
        return fullname;
    }

    public Map<String, Employee> addEmployee(String fullName, double salary, int department) {
        Employee employee = new Employee(checkFullName(fullName),salary,department);
        String id = key(checkFullName(fullName));
        if (!employeesBook.containsKey(id)) {
            employeesBook.put(id, employee);
            return employeesBook;
        } else {
            throw new EmployeeAlreadyAddedException();
        }
    }

    public  String removeEmployee(String fullName) {
        String id = key(fullName);
        if (employeesBook.containsKey(id)) {
            employeesBook.remove(id);
            return employeesBook.toString();
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public  String containsEmployee(String fullName) {
        String id = key(fullName);
        if (employeesBook.containsKey(id)) {
            return String.valueOf(employeesBook.get(id));
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public  String findAll() {

        return employeesBook.toString();
    }

    public String checkFullName(String fullName) {
        List<String> fAndI = List.of(StringUtils.splitPreserveAllTokens(fullName,"_"));
        if (!(fAndI.size() == 2)) {throw new BadRequestException();}
        if (StringUtils.isEmpty(String.join("", fAndI))) {
            throw new BadRequestException();
        } else if (!StringUtils.isAlpha((String.join("", fAndI)))) {
            throw new BadRequestException();
        }
        return fAndI.stream()
                .map(StringUtils::toRootLowerCase)
                .map(StringUtils::capitalize)
                .map(Object::toString)
                .collect(Collectors.joining("_"));
    }


}







