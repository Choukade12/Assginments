package org.example.service;

import org.example.entity.Employee;

import java.sql.SQLException;

public interface EmployeeService {
    public void createEmployee(Employee emp) throws SQLException;
    public void updateEmployee(Integer id, Employee emp) throws SQLException;
    public void deleteEmployee(Integer id)throws SQLException;
    public void getAllEmployee()throws SQLException;


}
