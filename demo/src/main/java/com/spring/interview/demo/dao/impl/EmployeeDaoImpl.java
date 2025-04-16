package com.spring.interview.demo.dao.impl;

import com.spring.interview.demo.dao.EmployeeDao;
import com.spring.interview.demo.model.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

//    @Autowired
//    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Employee employee) {

        Session cs = entityManager.unwrap(Session.class);

//        sessionFactory.getCurrentSession();
        cs.saveOrUpdate(employee);

    }

    @Override
    public void delete(Integer id) {

        Session cs = entityManager.unwrap(Session.class);
        cs.delete(cs.get(Employee.class, id));

    }

    @Override
    public Employee getSingle(Integer id) {

        Session cs = entityManager.unwrap(Session.class);
        return cs.get(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        Session cs = entityManager.unwrap(Session.class);
        Query<Employee> query = cs.createQuery("from Employee",Employee.class);

        return query.getResultList();
    }
}
