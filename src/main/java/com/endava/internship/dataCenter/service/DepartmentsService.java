package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.DepartmentDto;
import com.endava.internship.dataCenter.model.Departments;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.repository.DepartmentRepository;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentsService {

    private final DepartmentRepository departmentRepository;

    public Departments addDepartment(DepartmentDto departmentDto){
        return departmentRepository.save(Departments.from(departmentDto));
    }

    public Departments getDepartment(Integer id){
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException());

    }

    public List<Departments> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
