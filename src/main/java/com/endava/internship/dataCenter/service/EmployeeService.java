package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employees addEmployee(EmployeeDto employeeDto){
        return employeeRepository.save(Employees.from(employeeDto));
    }

    public Employees getEmployee(Integer id){
        //Long l = employeeRepository.count();
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException());

    }

    public List<Employees> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
