package org.example.service;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;


public class EmployeeServiceImple implements EmployeeService{
    private final SessionFactory sessionFactory;
    public EmployeeServiceImple(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void createEmployee(Employee emp) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(emp);
        transaction.commit();
        System.out.println("Employee Created");
        session.close();
    }

    @Override
    public void updateEmployee(Integer id, Employee emp) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        if(employee!=null){
            session.update(emp);
            System.out.print("Employee updated successfully");
        }
        else {
            System.out.println("This employee doesn't exists");
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteEmployee(Integer id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        if(employee!=null){
            session.delete(employee);
            System.out.print("Employee deleted successfully");

        }
        else{
            System.out.println("This employee doesn't exists");
        }
        transaction.commit();
    }

    @Override
    public void getAllEmployee() throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<Employee> nativeQuery = session.createNativeQuery("select * from Employee", (Class) Employee.class);
        for(Employee emp:nativeQuery.getResultList()){
            System.out.print(emp.getId());
            System.out.print(emp.getName());
            System.out.print(emp.getAddress());
           if(!emp.getDepartment().isEmpty()){
               emp.getDepartment().stream().forEach(s->System.out.print(s));
           }
        }
    }
}



