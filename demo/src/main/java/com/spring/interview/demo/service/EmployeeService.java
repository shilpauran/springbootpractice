package com.spring.interview.demo.service;

import com.spring.interview.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void save(Employee employee);

    public void delete(Integer id);

    public Employee getSingle(Integer id);

    public List<Employee> getAll();
}
