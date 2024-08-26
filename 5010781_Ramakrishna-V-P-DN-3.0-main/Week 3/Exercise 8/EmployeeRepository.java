package com.example.employeemanagementsystem;

import com.example.employeemanagementsystem.projection.EmployeeBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.id as id, e.name as name, e.email as email, d.name as departmentName " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeBasicInfo> findAllEmployeeBasicInfo();
}
