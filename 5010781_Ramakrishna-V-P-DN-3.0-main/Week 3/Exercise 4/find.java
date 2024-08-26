// Get all departments
List<Department> departments = departmentRepository.findAll();

// Get a specific department by ID
Optional<Department> department = departmentRepository.findById(1L);

// Get all employees
List<Employee> employees = employeeRepository.findAll();

// Get an employee by ID
Optional<Employee> employee = employeeRepository.findById(1L);
