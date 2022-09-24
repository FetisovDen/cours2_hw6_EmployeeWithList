package pro.sky.EmployeeWithList.Сoursework;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;

    public Employee(String firstname, String lastName) {
        this.firstName = firstname;
        this.lastName = lastName;

    }
    public  String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName +
                ", lastName='" + lastName +
                '}';
    }
}
