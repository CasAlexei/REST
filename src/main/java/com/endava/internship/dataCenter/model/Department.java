package com.endava.internship.dataCenter.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String departmentName;


    @OneToOne(mappedBy = "empDetail")
    private Employee employee;

    public static Department from(DepartmentDto departmentDto) {
        return builder()
                .departmentName(departmentDto.getDepartmentName())
                .build();
    }

}
