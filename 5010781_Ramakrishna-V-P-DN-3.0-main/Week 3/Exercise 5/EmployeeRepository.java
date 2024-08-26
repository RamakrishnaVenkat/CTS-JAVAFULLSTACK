package com.example.employeemanagementsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Method name convention
    List<Employee> findByDepartmentName(String departmentName);

    Optional<Employee> findByEmail(String email);

    // Using @Query annotation
    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Employee> findEmployeesByNameContaining(@Param("keyword") String keyword);

    // Named query
    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    @Query(name = "Employee.findByNameContaining")
    List<Employee> findEmployeesByNameContaining(@Param("name") String name);
}
