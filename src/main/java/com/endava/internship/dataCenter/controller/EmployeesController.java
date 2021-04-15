package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeesService employeesService;

    // create new employee
    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody EmployeeDto employeesDto){
        return employeesService.addEmployee(employeesDto);
    }

    // get employee by id
    @GetMapping("/employees/{id}")
    public Employees getEmployee(@PathVariable Integer id){
        return employeesService.getEmployee(id);
    }

    //  list of all employees
    @GetMapping("/employees")
    public List<Employees> getAllEmployee(){
        return employeesService.getAllEmployees();
    }
}
