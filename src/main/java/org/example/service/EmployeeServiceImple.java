package org.example.service;

import org.example.entity.Employee;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.SQLException;

public class EmployeeServiceImple implements EmployeeService{
    Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/jdbcdemo", "root", "Shubhi12*");

         Employee emp = new Employee();

    public EmployeeServiceImple() throws SQLException {
    }

    @Override
        public void createEmployee (@NotNull Employee emp) throws SQLException, NullPointerException{
        //this.emp = emp;
       // UUID id = emp.getEmpId();
        UUID id  = UUID.randomUUID();
        String name = emp.getEmpName();
        String dept = emp.getDepartment();

        String add = emp.getAddress();
        PreparedStatement ps = con.prepareStatement("insert into Employee values (?,?,?,?)");
        String string = id.toString();
        ps.setString(1, string);
        ps.setString(2, name);
        ps.setString(3, dept);
        ps.setString(4, add);
        ps.executeUpdate();
        System.out.println("New employee created");
    }

        @Override
        public void updateEmployee (UUID id, Employee emp) throws SQLException{
        PreparedStatement ps = con.prepareStatement("select * from Employee where empid = ?");
        ps.setString(1, String.valueOf(id));
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            PreparedStatement ps1 = con.prepareStatement("update Employee set empname = ? where empid = ?");
            ps1.setString(1,emp.getEmpName());
            ps1.setString(2,String.valueOf(id));
            ps1.executeUpdate();
            System.out.println("Value updated");
        }
    }

        @Override
        public void deleteEmployee (UUID id) throws SQLException{
            PreparedStatement ps = con.prepareStatement("select * from Employee where empid = ?");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PreparedStatement ps1 = con.prepareStatement("delete from Employee where empid=?");
                ps1.executeUpdate();
            }
            System.out.println("deleted successfully");
    }

        @Override
        public List<Employee> getAllEmployee () throws SQLException{
        List<Employee> ls = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("select * from Employee");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Employee emp1 = null;
            emp1.setEmpId(UUID.fromString(String.valueOf(rs.getString(1))));
            emp1.setEmpName(rs.getString(2));
            emp1.setDepartment(rs.getString(3));
            emp1.setAddress(rs.getString(4));
            ls.add(emp1);
        }
        return ls;
    }
    //con.close();
    }



