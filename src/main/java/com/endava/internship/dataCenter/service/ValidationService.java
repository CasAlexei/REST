package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Employees;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ValidationService {
    ResponseEntity<String> validateSalary(Double amount);

    ResponseEntity<String> validatePhoneNumber(Double phone);

    ResponseEntity<String> validateUserId(Integer userId);

    ResponseEntity<String> validateUser(EmployeeDto user);
}
