package org.example;

import org.example.entity.Address;
import org.example.entity.Asset;
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
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class).addAnnotatedClass(Department.class).addAnnotatedClass(Asset.class);
        SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
       Department department = new Department();
        Employee emp = new Employee();
        Address address = new Address();

        List<Department> listDepartment = createList(emp);
        List<Employee> empList = new ArrayList<>();
        empList.add(emp);
        List<Asset> listAsset = createAsset(empList);
        address.setCity("Pune");
        //AddressServiceImple addressServiceImple = new AddressServiceImple(sessionFactory);
        //addressServiceImple.saveAdd(address);
        emp.setName("Shubhi");
        emp.setAddress(address);
        emp.setDepartment(listDepartment);
        emp.setAsset(listAsset);
        EmployeeService employeeService = new EmployeeServiceImple(sessionFactory);
        employeeService.createEmployee(emp);
        /*Employee emp = new Employee();
        emp.setName("Abhi");
        EmployeeService employeeService = new EmployeeServiceImple(sessionFactory);
        employeeService.deleteEmployee(155);*/
    }

    public static List<Asset> createAsset(List<Employee> emp){
        List<Asset> list = new ArrayList<>();
        Asset asset = new Asset();
        asset.setName("laptop");
        asset.setEmployee(emp);
        Asset asset1 = new Asset();
        asset1.setName("laptop and mouse");
        asset1.setEmployee(emp);
        list.add(asset1);
        list.add(asset);
        return list;
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