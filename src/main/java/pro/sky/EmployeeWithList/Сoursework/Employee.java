package pro.sky.EmployeeWithList.Сoursework;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class Employee {
    private final Set<String> fullName;

    public Employee(String fullName) {
        this.fullName = Collections.singleton(fullName);

    }
    public String getFullName() {
        return fullName.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getFullName().equals(employee.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName());
    }
    @Override
    public String toString() {
        return fullName.toString();
    }
}
