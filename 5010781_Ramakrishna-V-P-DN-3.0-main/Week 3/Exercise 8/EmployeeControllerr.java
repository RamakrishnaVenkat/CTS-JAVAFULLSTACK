package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.EmployeeRepository;
import com.example.employeemanagementsystem.dto.EmployeeBasicInfoDTO;
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

    @GetMapping("/basic-info-dto")
    public List<EmployeeBasicInfoDTO> getAllEmployeeBasicInfoDTO() {
        return employeeRepository.findAllEmployeeBasicInfoDTO();
    }
}
