package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.DepartmentDto;
import com.endava.internship.dataCenter.model.Departments;
import com.endava.internship.dataCenter.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    // create new department
    @PostMapping("/departments")
    public Departments addDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentsService.addDepartment(departmentDto);
    }

    // get department by name
    @GetMapping("/departments/{id}")
    public Departments getDepartment(@PathVariable Integer id){
        return departmentsService.getDepartment(id);
    }

    //  list of all employees
    @GetMapping("/departments")
    public List<Departments> getAllDepartments(){
        return departmentsService.getAllDepartments();
    }
}
