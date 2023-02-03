package com.example.docker.domain;

import lombok.Data;

@Data
public class EmployeeEntitty {
    private String employeeId;
    private String employeeName;
    private String employeeEmail;
    private String employeeAddress;
}
