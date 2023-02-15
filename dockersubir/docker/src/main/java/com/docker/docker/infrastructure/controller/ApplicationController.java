package com.docker.docker.infrastructure.controller;

import java.util.List;

import com.docker.docker.aplication.port.EmployeePort;
import com.docker.docker.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/postgressApp")
public class ApplicationController {

    @Autowired
    EmployeePort employeePort;

    @GetMapping(value = "/employeeList")
    public List<Employee> getEmployees() {
        return employeePort.findAll();

    }

    @PostMapping(value = "/createEmp")
    public void createEmployee(@RequestBody Employee emp) {
        employeePort.insertEmployee(emp);

    }
    @PutMapping(value = "/updateEmp")
    public void updateEmployee(@RequestBody Employee emp) {
        employeePort.updateEmployee(emp);

    }
    @PutMapping(value = "/executeUpdateEmp")
    public void executeUpdateEmployee(@RequestBody Employee emp) {
        employeePort.executeUpdateEmployee(emp);

    }

    @DeleteMapping(value = "/deleteEmpById")
    public void deleteEmployee(@RequestBody Employee emp) {
        employeePort.deleteEmployee(emp);

    }


}