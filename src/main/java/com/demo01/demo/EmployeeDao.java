package com.demo01.demo;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Transactional
    public void saveEmployee(String name) {
        entityManager.persist(new Employee(name));
    }

    public List<String> listEmployees() {
        return entityManager.createQuery("select e from Employee e order by e.name", Employee.class)
                .getResultList().stream().map(Employee::getName)
                .collect(Collectors.toList());
    }

    public Employee findEmployeeById(long id) {
        return entityManager.find(Employee.class,id);
    }

    public Employee findEmployeeByName(String name) {
        return entityManager.createQuery("select e from Employee e where e.name = :name", Employee.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
