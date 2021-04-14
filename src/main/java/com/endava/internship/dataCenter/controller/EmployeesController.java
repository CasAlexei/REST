package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeeService employeeService;

    // create new employee
    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody EmployeeDto employeesDto){
        return employeeService.addEmployee(employeesDto);
    }

    // get employee by id
    @GetMapping("/employees/{id}")
    public Employees getEmployee(@PathVariable Integer id){
        return employeeService.getEmployee(id);
        //return id*100;
    }

    //  list all employees
    @GetMapping("/employees")
    public List<Employees> getAllEmployee(){
        return employeeService.getAllEmployees();
    }
}
