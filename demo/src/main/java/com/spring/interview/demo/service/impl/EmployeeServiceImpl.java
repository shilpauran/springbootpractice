package com.spring.interview.demo.service.impl;

import com.spring.interview.demo.dao.EmployeeDao;
import com.spring.interview.demo.model.Employee;
import com.spring.interview.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeDao dao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao dao)
    {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void save(Employee employee) {

        dao.save(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

            dao.delete(id);
    }

    @Override
    @Transactional
    public Employee getSingle(Integer id) {
        return dao.getSingle(id);
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return dao.getAll();
    }
}
