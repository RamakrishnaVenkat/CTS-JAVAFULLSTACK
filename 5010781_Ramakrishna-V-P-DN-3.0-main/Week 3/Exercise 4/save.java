// Update a department
Department department = departmentRepository.findById(1L).orElseThrow();
department.setName("HR");
departmentRepository.save(department);

// Update an employee
Employee employee = employeeRepository.findById(1L).orElseThrow();
employee.setName("Alice Johnson");
employeeRepository.save(employee);
