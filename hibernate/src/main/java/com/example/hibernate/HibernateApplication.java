package com.example.hibernate;

import com.example.hibernate.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

    @Autowired
    private EmployeeDao employeeDao;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = getEmployee();
        employeeDao.createEmployee(employee);
    }

    private Employee getEmployee() {
        Employee employee = new Employee();
        employee.setName("Sean Murphy");
        employee.setSalary(80000.00);
        employee.setDob(new Date());
        return employee;
    }


}
