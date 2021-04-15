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

    // create new department
    @PostMapping("/departments")
    public Departments addDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentsService.addDepartment(departmentDto);
    }

//    // get department by name
//    @GetMapping("/employees/{id}")
//    public Employees getEmployee(@PathVariable String id){
//        return departmentsService.getDepartment(name);
//    }

//    //  list of all employees
//    @GetMapping("/employees")
//    public List<Employees> getAllEmployee(){
//        return employeeService.getAllEmployees();
//    }
}
