package org.example;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImple;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Create new employee
        Class.forName("com.mysql.jdbc.Driver");

        Employee emp = new Employee();
        EmployeeService employeeService = new EmployeeServiceImple();
        emp.setEmpName("Shubhi");
        emp.setDepartment("SDE");
        emp.setAddress("banglore");
        employeeService.createEmployee(emp);
    }
}