package com.endava.internship.dataCenter.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private double salary;
    private double commissionPct;
}
