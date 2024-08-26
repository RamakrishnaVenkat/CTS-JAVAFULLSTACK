package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.EmployeeRepository;
import com.example.employeemanagementsystem.projection.EmployeeBasicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/basic-info")
    public List<EmployeeBasicInfo> getAllEmployeeBasicInfo() {
        return employeeRepository.findAllEmployeeBasicInfo();
    }
}
