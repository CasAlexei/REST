package com.endava.internship.dataCenter.model;

import lombok.Data;

@Data
public class DepartmentDto {
    private String departmentName;
    private Integer managerId;
    private Integer locationId;
}