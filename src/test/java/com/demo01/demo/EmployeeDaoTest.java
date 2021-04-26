package com.demo01.demo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveThanList() {
        employeeDao.saveEmployee("John Doe");
        IntStream.range(0,100)
                .forEach(i -> employeeDao.saveEmployee(new Employee("John Doe 0" + i)));

//        Employee employee = employeeDao.findEmployeeByName("John Doe");
        List<String> names = employeeDao.listEmployees();
        System.out.println(names);
//        assertEquals("John Doe", employee.getName());
    }



}