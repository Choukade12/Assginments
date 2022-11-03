package org.example;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    public Employee create(Employee emp);
    public Employee read(UUID id);
    public boolean findById(UUID id);
    public List<Employee> getAll();

}
