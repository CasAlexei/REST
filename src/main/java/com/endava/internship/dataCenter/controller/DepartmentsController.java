package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.DepartmentDto;
import com.endava.internship.dataCenter.model.Departments;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    // POST  -  create new department
    @PostMapping("/departments")
    public Departments addDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentsService.addDepartment(departmentDto);
    }

    // GET(id)  -  get department by name
    @GetMapping("/departments/{id}")
    public Departments getDepartment(@PathVariable Integer id){
        return departmentsService.getDepartment(id);
    }

    //  GET  -  list of all departments
    @GetMapping("/departments")
    public List<Departments> getAllDepartments(){
        return departmentsService.getAllDepartments();
    }

    // PUT - update an existing department
    @PutMapping("/departments/{id}")
    public Departments getDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto){
        return departmentsService.updateDepartment(id, departmentDto);
    }
}
