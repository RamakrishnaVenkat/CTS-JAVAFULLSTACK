package com.example.employeemanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        Department department = new Department(null, "Finance", null);
        departmentRepository.save(department);

        Employee employee = new Employee(null, "John Doe", "john.doe@example.com", department);
        employeeRepository.save(employee);

        System.out.println("Employees in Finance: " + employeeRepository.findByDepartmentName("Finance"));
    }
}
