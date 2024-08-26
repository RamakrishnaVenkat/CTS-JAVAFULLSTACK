package com.example.employeemanagementsystem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Derived query method to find employees by their department
    List<Employee> findByDepartmentName(String departmentName);
    
    // Derived query method to find an employee by email
    Employee findByEmail(String email);
}
