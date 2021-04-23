package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeesService {

    private final EmployeeRepository employeeRepository;

    public Employees getEmployeeById(Integer id){
        log.info("IN EmployeeRepository getEmployeeById {}", id);
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found employee"));
    }


    public Employees addEmployee(EmployeeDto employeeDto){
        Employees employee = new Employees();

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setSalary(employeeDto.getSalary());
        employee.setCommissionPct(employeeDto.getCommissionPct());
        employee.setJobId(employeeDto.getJobId());

        log.info("IN EmployeeRepository addEmployee with id = {}", employee.getEmployeeId());

        return employeeRepository.save(employee);
    }


    public List<Employees> getAllEmployees(){
        log.info("IN EmployeeRepository getAllEmployees");
        return employeeRepository.findAll();
    }

    public Employees updateEmployees(Integer id, EmployeeDto employeeDto){
        log.info("IN EmployeeRepository updateEmployees {}", id);

        Employees employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found employee"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setCommissionPct(employeeDto.getCommissionPct());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id){
        log.info("IN EmployeeRepository deleteEmployee with Id = {}", id);
        employeeRepository.deleteById(id);
    }

}
