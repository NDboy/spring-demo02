package com.demo01.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeMain {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
            employeeDao.saveEmployee("John Doe");

            System.out.println(employeeDao.listEmployees());
        }
    }
}
