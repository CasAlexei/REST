package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.beans.IntrospectionException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeesService employeesService;

    // POST  -  create new employee
    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody EmployeeDto employeesDto){
        //return employeesService.addEmployee(employeesDto);
        return employeesService.addEmployeeJDBC(employeesDto);
    }

    // GET(id)  -  get employee by id
    @GetMapping("/employees/{id}")
    public Employees getEmployee(@PathVariable Integer id){
        //return employeesService.getEmployee(id);
        return employeesService.getEmployeeJDBC(id);
    }

    // GET  -  list of all employees
    @GetMapping("/employees")
    public List<Employees> getAllEmployee(){
        return employeesService.getAllEmployees();
    }

    // PUT - update an existing employee
    @PutMapping("/employees/{id}")
    public Employees getEmployees(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
        return employeesService.updateEmployees(id, employeeDto);
    }

}
