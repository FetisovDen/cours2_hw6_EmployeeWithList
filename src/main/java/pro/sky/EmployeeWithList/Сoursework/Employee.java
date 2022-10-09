package pro.sky.EmployeeWithList.Сoursework;

import java.util.List;
import java.util.Objects;


public class Employee {
    private String fullName;
    private  double salary;
    private  int department;

    public Employee(String fullName, double salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
    }

    public  void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public  String getFullName() {
        return fullName;
    }


    public  double getSalary() {

        return salary;
    }

    public  int getDepartment() {

        return department;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.getSalary(), getSalary()) == 0 && getDepartment() == employee.getDepartment() && getFullName().equals(employee.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getSalary(), getDepartment());
    }

    @Override
    public String toString() {
        return " " + fullName +
                ", salary=" + salary +
                ", department=" + department;
    }
}
