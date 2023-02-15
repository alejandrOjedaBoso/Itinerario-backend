package com.docker.docker.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee {
   @Column(name = "employeeName")
    private String employeeName;
   @Id
    private String employeeId;
   @Column(name = "employeeAddress")
   private String employeeAddress;
   @Column(name = "employeeEmail")
   private String employeeEmail;
}
