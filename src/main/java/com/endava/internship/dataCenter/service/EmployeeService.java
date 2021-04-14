package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.Employee;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeDto employeeDto){
        return employeeRepository.save(Employee.from(employeeDto));
    }

    public Employee getEmployee(Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
}
