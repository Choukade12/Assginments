package org.example.entity;

import java.util.UUID;

public class Employee {
    private String empName;
    private UUID empId;
    private String department;
    private String address;

    public Employee() {
    }

    public Employee(String empName, String department, String address) {
        this.empName = empName;
        this.department = department;
        this.address = address;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public UUID getEmpId() {
        return empId;
    }

    public void setEmpId(UUID empId) {
        this.empId = empId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
