import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll(Sort sort);

    List<Employee> findByDepartmentName(String departmentName, Sort sort);
}
