package com.endava.internship.dataCenter.repository;

import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Employees;


import java.util.List;


public interface EmployeeRepository{

    Employees getEmployeeById(Integer id);

    Employees addEmployee(EmployeeDto employeeDto);

    List<Employees> getAllEmployees();

    Employees updateEmployees(Integer id, EmployeeDto employeeDto);

    void deleteEmployee(Integer id);

}
