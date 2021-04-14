package com.endava.internship.dataCenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private double salary;
    private double commissionPct;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id")
    private Departments empDetail;


    public static Employees from(EmployeeDto employeeDto) {
        return builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .phoneNumber(employeeDto.getPhoneNumber())
                .hireDate(employeeDto.getHireDate())
                .salary(employeeDto.getSalary())
                .commissionPct(employeeDto.getCommissionPct())
                .build();
        }
}
