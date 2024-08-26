package com.example.employeemanagementsystem;

import com.example.employeemanagementsystem.dto.EmployeeBasicInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeBasicInfoDTO(e.id, e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeBasicInfoDTO> findAllEmployeeBasicInfoDTO();
}
