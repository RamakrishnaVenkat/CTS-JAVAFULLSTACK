package com.example.employeemanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        Department department1 = new Department(null, "HR", null);
        Department department2 = new Department(null, "Engineering", null);

        departmentRepository.saveAll(Arrays.asList(department1, department2));

        Employee employee1 = new Employee(null, "Alice", "alice@example.com", department1);
        Employee employee2 = new Employee(null, "Bob", "bob@example.com", department2);

        employeeRepository.saveAll(Arrays.asList(employee1, employee2));
    }
}
