package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import com.spring.interview.demo.LamdaExpressions.classes.Models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmployeesByAge {
    public List<Employee> getEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("shilpa");
        employee1.setSalary(10000);
        employee1.setAge(32);
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setName("shilpa");
        employee2.setSalary(10000);
        employee2.setAge(32);
        employees.add(employee2);
        return employees;
    }

    public void group()
    {
        Map<Integer,List<Employee>> map = getEmployees().stream().collect(Collectors.groupingBy(Employee::getAge));
        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }
}
