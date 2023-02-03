package com.example.docker.infrastructure.mapper;

import com.example.docker.domain.EmployeeEntitty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<EmployeeEntitty> {
    @Override
    public EmployeeEntitty mapRow(ResultSet rs, int arg1) throws SQLException {
        EmployeeEntitty emp = new EmployeeEntitty();
        emp.setEmployeeId(rs.getString("employeeId"));
        emp.setEmployeeName(rs.getString("employeeName"));
        emp.setEmployeeEmail(rs.getString("employeeEmail"));
        emp.setEmployeeAddress(rs.getString("employeeAddress"));

        return emp;
    }
}
