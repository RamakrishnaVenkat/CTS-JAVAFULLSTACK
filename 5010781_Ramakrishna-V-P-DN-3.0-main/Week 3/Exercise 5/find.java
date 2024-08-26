//Find employees by department name
List<Employee> findByDepartmentName(String departmentName);

//Find employees by email
Optional<Employee> findByEmail(String email);

//Find all departments with a specific name
List<Department> findByName(String name);

//Find employees with a specific email using JPQL
@Query("SELECT e FROM Employee e WHERE e.email = :email")
Optional<Employee> findEmployeeByEmail(@Param("email") String email);

//Find employees whose name contains a specific keyword (case insensitive)
@Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
List<Employee> findEmployeesByNameContaining(@Param("keyword") String keyword);

//Find departments with more than a certain number of employees
@Query("SELECT d FROM Department d WHERE SIZE(d.employees) > :minEmployeeCount")
List<Department> findDepartmentsWithMinEmployees(@Param("minEmployeeCount") int minEmployeeCount);

//Find employees by department name using a named query
@Query(name = "Employee.findByDepartmentName")
List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

//Find employees by name containing keyword using a named query
@Query(name = "Employee.findByNameContaining")
List<Employee> findEmployeesByNameContaining(@Param("name") String name);


