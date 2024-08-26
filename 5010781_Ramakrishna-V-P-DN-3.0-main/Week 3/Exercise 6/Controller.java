import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EmployeeController {

    @GetMapping("/employees/sorted")
    public Page<Employee> getPaginatedAndSortedEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return employeeService.getPaginatedAndSortedEmployees(page, size, sortBy, direction);
    }

    @GetMapping("/employees/department/sorted")
    public Page<Employee> getPaginatedAndSortedEmployeesByDepartment(
            @RequestParam String departmentName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return employeeService.getPaginatedAndSortedEmployeesByDepartment(departmentName, page, size, sortBy, direction);
    }
}
