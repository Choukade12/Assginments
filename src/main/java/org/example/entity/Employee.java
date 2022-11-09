package org.example.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="Employee")
public class Employee {
   public Employee() {
   }

   @OneToOne
   @JoinColumn(name = "addressId")
   @Cascade(org.hibernate.annotations.CascadeType.ALL)
   private Address address;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
   private List<Department> department;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   public List<Department> getDepartment() {
      return department;
   }

   public void setDepartment(List<Department> department) {
      this.department = department;
   }

   @Column(name = "EmpName")
   private String name;


   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }



   public String getName() {
      return name;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }
}
