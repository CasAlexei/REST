package com.endava.internship.dataCenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer departmentId;
    private String departmentName;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employees")
//    private List<Employees> employeesList;

    public static Departments from(DepartmentDto departmentDto) {
        return builder()
                .departmentName(departmentDto.getDepartmentName())
                .build();
    }

}
