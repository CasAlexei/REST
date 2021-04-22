package com.endava.internship.dataCenter.repository;


import com.endava.internship.dataCenter.model.DepartmentDto;
import com.endava.internship.dataCenter.model.Departments;

import java.util.List;

public interface DepartmentRepository{

    Departments getDepartmentById(Integer id);

    Departments addDepartment(DepartmentDto departmentDto);

    List<Departments> getAllDepartments();

    Departments updateDepartment(Integer id, DepartmentDto departmentDto);

    void deleteDepartment(Integer id);

}