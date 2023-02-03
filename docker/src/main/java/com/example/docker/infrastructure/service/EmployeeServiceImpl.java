package com.example.docker.infrastructure.service;

import com.example.docker.aplication.port.EmployeePort;
import com.example.docker.domain.EmployeeEntitty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Resource
    EmployeePort employeeDao;
    @Override
    public List<EmployeeEntitty> findAll() {
        return employeeDao.findAll();
    }
    @Override
    public void insertEmployee(EmployeeEntitty emp) {
        employeeDao.insertEmployee(emp);

    }
    @Override
    public void updateEmployee(EmployeeEntitty emp) {
        employeeDao.updateEmployee(emp);

    }
    @Override
    public void executeUpdateEmployee(EmployeeEntitty emp) {
        employeeDao.executeUpdateEmployee(emp);

    }

    @Override
    public void deleteEmployee(EmployeeEntitty emp) {
        employeeDao.deleteEmployee(emp);

    }
}
