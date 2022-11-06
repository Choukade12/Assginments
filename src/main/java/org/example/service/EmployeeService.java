package org.example.service;

import org.example.entity.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    public void createEmployee(Employee emp) throws SQLException;
    public void updateEmployee(UUID id, Employee emp) throws SQLException;
    public void deleteEmployee(UUID id)throws SQLException;
    public List<Employee> getAllEmployee()throws SQLException;


}
