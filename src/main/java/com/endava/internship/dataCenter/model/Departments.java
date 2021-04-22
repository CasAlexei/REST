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
@Table(name="departments")
public class Departments {
    @Id
    @SequenceGenerator(name="departments_seq",sequenceName="departments_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departments_seq")
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "department_name")
    private String departmentName;
//    @Column(name = "manager_id")
//    private Integer managerId;
//    @Column(name = "location_id")
//    private Integer locationId;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employees")
//    private List<Employees> employeesList;

    public static Departments from(DepartmentDto departmentDto) {
        return builder()
                .departmentName(departmentDto.getDepartmentName())
                //.managerId(departmentDto.getManagerId())
                //.locationId(departmentDto.getLocationId())
                .build();
    }

}
