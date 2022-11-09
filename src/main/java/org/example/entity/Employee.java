package org.example.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="Employee")
public class Employee {
   public Employee() {
   }

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "id")
   private Address address;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
   private List<Department> department;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer empID;

   @ManyToMany(cascade = CascadeType.ALL)
   private List<Asset> asset;

   public List<Asset> getAsset() {
      return asset;
   }

   public void setAsset(List<Asset> asset) {
      this.asset = asset;
   }

   @Column(name = "EmpName")
   private String name;

   public List<Department> getDepartment() {
      return department;
   }

   public void setDepartment(List<Department> department) {
      this.department = department;
   }


   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public Integer getEmpID() {
      return empID;
   }

   public void setEmpID(Integer empID) {
      this.empID = empID;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
