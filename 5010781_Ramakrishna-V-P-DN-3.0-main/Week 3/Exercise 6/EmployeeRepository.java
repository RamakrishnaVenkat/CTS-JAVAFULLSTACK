package com.example.employeemanagementsystem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Method to retrieve a paginated list of employees
    Page<Employee> findAll(Pageable pageable);

    // Additional custom query methods with pagination support can also be added
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
}
