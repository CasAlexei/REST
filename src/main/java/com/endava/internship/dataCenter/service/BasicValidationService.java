package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Employees;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BasicValidationService implements ValidationService{
    @Override
    public ResponseEntity<String> validateSalary(Double amount) {
        return null;
    }

    @Override
    public ResponseEntity<String> validatePhoneNumber(Double phone) {
        return null;
    }

    @Override
    public ResponseEntity<String> validateUserId(Integer userId) {
        return null;
    }

    @Override
    public ResponseEntity<String> validateUser(EmployeeDto user) {
        //  First name and Last name - not to be null, empty or blank
        String checkFirstName = user.getFirstName();
        String checkLastName = user.getLastName();
        System.out.println(checkFirstName);
        if(checkFirstName == null || checkLastName == null){
            return new ResponseEntity<>("First name and Last name - not to be null", HttpStatus.BAD_REQUEST);
        }
        if(checkFirstName.trim().isEmpty() || checkLastName.trim().isEmpty()){
            return new ResponseEntity<>("First name and Last name - not to be empty or blank", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("First name is ok", HttpStatus.OK);
    }
}
