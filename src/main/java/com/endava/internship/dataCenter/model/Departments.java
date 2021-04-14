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
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer departmentId;
    private String departmentName;


    @OneToOne(mappedBy = "empDetail")
    private Employees employees;

    public static Departments from(DepartmentDto departmentDto) {
        return builder()
                .departmentName(departmentDto.getDepartmentName())
                .build();
    }

}
