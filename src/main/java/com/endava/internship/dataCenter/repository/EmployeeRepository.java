package com.endava.internship.dataCenter.repository;

import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Employees;


import java.util.List;


public interface EmployeeRepository{

    Employees getEmployeeById(Long id);

    Employees addEmployee(EmployeeDto employeeDto);

    List<Employees> getAllEmployees();

    Employees updateEmployees(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);

}
