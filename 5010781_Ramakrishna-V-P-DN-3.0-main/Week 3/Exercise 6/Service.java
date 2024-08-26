import com.example.employeemanagementsystem.Employee;
import com.example.employeemanagementsystem.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getSortedEmployees(String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        return employeeRepository.findAll(sort);
    }

    public List<Employee> getSortedEmployeesByDepartment(String departmentName, String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        return employeeRepository.findByDepartmentName(departmentName, sort);
    }
}
