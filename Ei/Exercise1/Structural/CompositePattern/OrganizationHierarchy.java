package Exercise1.Structural.CompositePattern;

import java.util.ArrayList;
import java.util.List;

interface Employee {
    void showDetails();
}

class Developer implements Employee {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Developer: " + name);
    }
}

class Manager implements Employee {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Manager: " + name);
    }
}

class Department implements Employee {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void showDetails() {
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }
}

// Main
public class OrganizationHierarchy {
    public static void main(String[] args) {
        Developer dev1 = new Developer("John");
        Developer dev2 = new Developer("Jane");

        Manager manager = new Manager("Robert");

        Department devDepartment = new Department();
        devDepartment.addEmployee(dev1);
        devDepartment.addEmployee(dev2);

        Department org = new Department();
        org.addEmployee(manager);
        org.addEmployee(devDepartment);

        org.showDetails(); // Displays hierarchy
    }
}
