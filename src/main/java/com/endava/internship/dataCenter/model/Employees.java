package com.endava.internship.dataCenter.model;

import javafx.scene.input.DataFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private double salary;
    private double commissionPct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id")
    private Departments departmentDetail;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id", nullable = false)
//    private Departments departments;


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
