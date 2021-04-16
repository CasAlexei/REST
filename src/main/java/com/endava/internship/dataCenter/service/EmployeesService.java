package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeesService {

    private final EmployeeRepository employeeRepository;

    public Employees addEmployee(EmployeeDto employeeDto){
        Employees employee = new Employees();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setSalary(employeeDto.getSalary());
        employee.setCommissionPct(employeeDto.getCommissionPct());
        employee.setJobId(1);
        return employeeRepository.save(employee);
    }

    public Employees getEmployee(Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found employee"));

    }

    public List<Employees> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employees updateEmployees(Integer id, EmployeeDto employeeDto){
        Employees employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found employee"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setCommissionPct(employeeDto.getCommissionPct());
return employeeRepository.save(employee);
    }
}
