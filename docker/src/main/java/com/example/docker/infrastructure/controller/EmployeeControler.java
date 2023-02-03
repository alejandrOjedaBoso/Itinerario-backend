package com.example.docker.infrastructure.controller;

import com.example.docker.domain.EmployeeEntitty;
import com.example.docker.infrastructure.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmployeeControler {
    @Autowired
    EmployeeService employeeService;
    @GetMapping(value = "/employeeList")
    public List<EmployeeEntitty> getEmployees() {
        return employeeService.findAll();

    }
    @PostMapping(value = "/createEmp")
    public void createEmployee(@RequestBody EmployeeEntitty emp) {
        employeeService.insertEmployee(emp);

    }
    @PutMapping(value = "/updateEmp")
    public void updateEmployee(@RequestBody EmployeeEntitty emp) {
        employeeService.updateEmployee(emp);

    }
    @PutMapping(value = "/executeUpdateEmp")
    public void executeUpdateEmployee(@RequestBody EmployeeEntitty emp) {
        employeeService.executeUpdateEmployee(emp);

    }

    @DeleteMapping(value = "/deleteEmpById")
    public void deleteEmployee(@RequestBody EmployeeEntitty emp) {
        employeeService.deleteEmployee(emp);

    }
}
