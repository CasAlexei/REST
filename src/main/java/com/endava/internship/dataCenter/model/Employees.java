package com.endava.internship.dataCenter.model;

import lombok.Builder;
import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private double salary;
    private double commissionPct;

    public static Employees from(EmployeesDto employeesDto) {
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
