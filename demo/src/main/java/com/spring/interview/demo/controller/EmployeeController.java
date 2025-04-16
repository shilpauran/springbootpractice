package com.spring.interview.demo.controller;

import com.spring.interview.demo.model.Employee;
import com.spring.interview.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    EmployeeController(EmployeeService service)
    {
        this.service = service;
    }

    @PostMapping("/save")
    public void save(@RequestBody  Employee employee)
    {
        service.save(employee);
    }

    @PutMapping("/update")
    public void update(@RequestBody Employee employee)
    {
        service.save(employee);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Employee get(@PathVariable Integer id)
    {
        return service.getSingle(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id)
    {
         service.delete(id);
    }

}
