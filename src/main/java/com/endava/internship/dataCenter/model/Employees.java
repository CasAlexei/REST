package com.endava.internship.dataCenter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employees {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private double salary;
    private double commissionPct;

    static Employees from(EmployeesDto employeesDto) {
        return builder()
                .firstName(employeesDto.getFirstName())
                .lastName(employeesDto.getLastName())
                .email(employeesDto.getEmail())
                .phoneNumber(employeesDto.getPhoneNumber())
                .hireDate(employeesDto.getHireDate())
                .salary(employeesDto.getSalary())
                .commissionPct(employeesDto.getCommissionPct())
                .build();
        }
    }
