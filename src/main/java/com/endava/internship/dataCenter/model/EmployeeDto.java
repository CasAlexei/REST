package com.endava.internship.dataCenter.model;

import javafx.scene.input.DataFormat;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private Double salary;
    private Double commissionPct;
}
