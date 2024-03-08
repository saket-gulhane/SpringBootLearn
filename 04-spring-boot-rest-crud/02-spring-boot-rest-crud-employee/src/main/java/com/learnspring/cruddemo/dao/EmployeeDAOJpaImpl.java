package com.learnspring.cruddemo.dao;

import com.learnspring.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements  EmployeeDAO {
    //define fields for entity manager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployess = entityManager.merge(theEmployee);
        return dbEmployess;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee  = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
