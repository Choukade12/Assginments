package org.example;

import org.example.entity.Address;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.service.AddressService;
import org.example.service.AddressServiceImple;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImple;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException{
        //Create new employee
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class).addAnnotatedClass(Department.class);
        SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        /*Department department = new Department();
        Employee emp = new Employee();
        List<Department> listDepartment = createList(emp);
        Address address = new Address();
        address.setCity("Pune");
        /*AddressServiceImple addressServiceImple = new AddressServiceImple(sessionFactory);
        //addressServiceImple.saveAdd(address);
        emp.setName("Shubhi");
        emp.setAddress(address);
        emp.setDepartment(listDepartment);
        EmployeeService employeeService = new EmployeeServiceImple(sessionFactory);
        employeeService.createEmployee(emp);
        Employee emp1 = new Employee();
        emp1.setName("abhi");
        emp1.setAddress(address);
        List<Department> listDepartment1 = createList(emp1);

        emp1.setDepartment(listDepartment1);
        employeeService.createEmployee(emp1);*/
        EmployeeService employeeService = new EmployeeServiceImple(sessionFactory);
        //Employee emp2 = new Employee();
        employeeService.deleteEmployee(48);


    }

    public static List<Department> createList(Employee emp){
        List<Department> list = new ArrayList<>();
        Department dep1 = new Department();
        dep1.setDeptName("HR");
        dep1.setEmployee(emp);
        Department dep2 = new Department();
        dep2.setDeptName("Testing");
        dep2.setEmployee(emp);
        list.add(dep1);
        list.add(dep2);
        return list;
    }
}