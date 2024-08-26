// Create a new department
Department department = new Department(null, "IT", null);
departmentRepository.save(department);

// Create a new employee
Employee employee = new Employee(null, "Alice Smith", "alice.smith@example.com", department);
employeeRepository.save(employee);
