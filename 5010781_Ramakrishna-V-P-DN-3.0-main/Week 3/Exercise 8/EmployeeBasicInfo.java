package com.example.employeemanagementsystem.projection;

public interface EmployeeBasicInfo {
    
    Long getId();
    
    String getName();
    
    String getEmail();
    
    String getDepartmentName(); // Custom property to fetch the department's name
}
