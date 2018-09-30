/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nakeawvichit
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/emp")
    public Employee getEmployee() {
        Employee employeeModel = new Employee();
        employeeModel.setId(1);
        employeeModel.setName("Na");
        employeeModel.setAge(24);
        employeeModel.setCreatedate(new Date());
        return employeeModel;
    }

    @PostMapping("/emp/save")
    public Employee save(
            @Valid 
            @RequestBody 
                    Employee employee) {
        employee.setCreatedate(new Date());
        return employeeRepository.save(employee);
    }

}
