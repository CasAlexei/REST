package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.Employee;
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
    public Employee addEmployee(@RequestBody EmployeeDto employeesDto){
        return employeeService.addEmployee(employeesDto);
    }

    // get employee by id
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }

    //  list all employees
    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        return employeeService.getAllEmployee();
    }
}
