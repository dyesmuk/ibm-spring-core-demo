package com.ibm.demo.jdbc;

import com.ibm.demo.jdbc.config.AppConfig;
import com.ibm.demo.jdbc.dao.EmployeeDao;
import com.ibm.demo.jdbc.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        EmployeeDao dao = new EmployeeDao(jdbcTemplate);

        // Create table
        dao.createTable();

        // Insert data
        dao.insert(new Employee(1, "John", 50000));
        dao.insert(new Employee(2, "Jane", 60000));

        // Fetch data
        dao.getAll().forEach(System.out::println);

        context.close();
    }
}