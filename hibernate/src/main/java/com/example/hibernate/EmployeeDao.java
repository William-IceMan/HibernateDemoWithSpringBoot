package com.example.hibernate;

import com.example.hibernate.tables.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void createEmployee(Employee employee){
        Session session= null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Integer id =(Integer) session.save(employee);
            System.out.println("Employee is created With Id::"+id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
