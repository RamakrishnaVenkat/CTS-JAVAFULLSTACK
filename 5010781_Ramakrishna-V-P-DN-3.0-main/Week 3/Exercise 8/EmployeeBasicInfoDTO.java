package com.example.employeemanagementsystem.dto;

public class EmployeeBasicInfoDTO {
    
    private Long id;
    private String name;
    private String email;
    private String departmentName;

    public EmployeeBasicInfoDTO(Long id, String name, String email, String departmentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    // Getters and setters
}
