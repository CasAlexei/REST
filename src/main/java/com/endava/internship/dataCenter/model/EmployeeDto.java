package com.endava.internship.dataCenter.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDateTime hireDate;
    private Double salary;
    private Double commissionPct;
}
