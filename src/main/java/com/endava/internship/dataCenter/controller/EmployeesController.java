package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeesDto;
import com.endava.internship.dataCenter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeeService employeeService;

    //  create new employee
    @PostMapping("/employees")
    public Employees addEmployee(EmployeesDto employeesDto){
        return employeeService.addEmployee(employeesDto);
    }
}
