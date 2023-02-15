package com.docker.docker.aplication.port;

import com.docker.docker.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeePort {
        List<Employee> findAll();

        void insertEmployee(Employee emp);

        void updateEmployee(Employee emp);

        void executeUpdateEmployee(Employee emp);

        public void deleteEmployee(Employee emp);
}
