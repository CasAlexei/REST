package com.endava.internship.dataCenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "departmentDetail")
    private List<Employees> employeesList;

    public static Departments from(DepartmentDto departmentDto) {
        return builder()
                .departmentName(departmentDto.getDepartmentName())
                .build();
    }

}
