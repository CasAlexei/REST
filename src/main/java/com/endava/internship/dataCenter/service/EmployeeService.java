package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeesDto;
import com.endava.internship.dataCenter.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeesRepository employeesRepository;

    public Employees addEmployee(EmployeesDto employeesDto){
        return employeesRepository.save(Employees.from(employeesDto));
    }
}
