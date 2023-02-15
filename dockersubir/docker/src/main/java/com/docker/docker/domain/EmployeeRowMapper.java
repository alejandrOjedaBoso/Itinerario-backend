package com.docker.docker.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.docker.docker.domain.Employee;
import org.springframework.jdbc.core.RowMapper;


public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
        Employee emp = new Employee();
        emp.setEmployeeId(rs.getString("employeeId"));
        emp.setEmployeeName(rs.getString("employeeName"));
        emp.setEmployeeEmail(rs.getString("employeeEmail"));

        return emp;
    }


}
