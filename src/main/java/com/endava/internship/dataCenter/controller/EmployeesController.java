package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.JobHistory;
import com.endava.internship.dataCenter.service.BasicValidationService;
import com.endava.internship.dataCenter.service.EmployeesService;
import com.endava.internship.dataCenter.service.JobHistoryService;
import com.endava.internship.dataCenter.service.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeesService employeesService;
    private final JobHistoryService jobHistoryService;
    private ValidationService validationService = new BasicValidationService();

    //  GET(id)  -  get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employees> getEmployee(@PathVariable Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Employees employee = this.employeesService.getEmployeeById(id);

        if(employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // GET  -  list of all employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employees>> getAllEmployees(){
        List<Employees> employeesList = this.employeesService.getAllEmployees();

        if (employeesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employeesList, HttpStatus.OK);
    }

    // POST  -  create new employee
    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto employeesDto){
        //  First name and Last name - not to be null, empty or blank
        String checkFirstName = employeesDto.getFirstName();
        String checkLastName = employeesDto.getLastName();
        System.out.println(checkFirstName);
        if(checkFirstName == null || checkLastName == null){
            return new ResponseEntity<>("First name and Last name - not to be null", HttpStatus.BAD_REQUEST);
        }
        if(checkFirstName.trim().isEmpty() || checkLastName.trim().isEmpty()){
            return new ResponseEntity<>("First name and Last name - not to be empty or blank", HttpStatus.BAD_REQUEST);
        }

        // Email - to match email format
        boolean checkEmail = employeesDto.getEmail().matches("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "("
                + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");
        if(!checkEmail){
            return new ResponseEntity<>("Email is not correct", HttpStatus.BAD_REQUEST);
        }

        // Phone number - to start with 0 and and contain exactly 9 digits
        boolean checkPhoneNumber = employeesDto.getPhoneNumber().matches("^0\\d{9}");
        if(!checkPhoneNumber){
            return new ResponseEntity<>("Phone number is not correct. Need to start with 0 and contain exactly 9 digits", HttpStatus.BAD_REQUEST);
        }

        // Salary - min 1.0
        boolean checkSalary = employeesDto.getSalary() >= 1.0;
        if(!checkSalary){
            return new ResponseEntity<>("Check salary. Min value is 1.0", HttpStatus.BAD_REQUEST);
        }

        Employees employees = this.employeesService.addEmployee(employeesDto);

        return new ResponseEntity<>("Employee added", HttpStatus.CREATED);
    }

    // PUT - update an existing employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
        //  First name and Last name - not to be null, empty or blank
        String checkFirstName = employeeDto.getFirstName();
        String checkLastName = employeeDto.getLastName();
        if(checkFirstName == null || checkLastName == null){
            return new ResponseEntity<>("First name and Last name - not to be null", HttpStatus.BAD_REQUEST);
        }
        if(checkFirstName.trim().isEmpty() || checkLastName.trim().isEmpty()){
            return new ResponseEntity<>("First name and Last name - not to be empty or blank", HttpStatus.BAD_REQUEST);
        }

        // Email - to match email format
        boolean checkEmail = employeeDto.getEmail().matches("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "("
                + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");
        if(!checkEmail){
            return new ResponseEntity<>("Email is not correct", HttpStatus.BAD_REQUEST);
        }

        // Phone number - to start with 0 and and contain exactly 9 digits
        boolean checkPhoneNumber = employeeDto.getPhoneNumber().matches("^0\\d{9}");
        if(!checkPhoneNumber){
            return new ResponseEntity<>("Phone number is not correct. Need to start with 0 and contain exactly 9 digits",
                    HttpStatus.BAD_REQUEST);
        }

        // Salary - min 1.0
        boolean checkSalary = employeeDto.getSalary() >= 1.0;
        if(!checkSalary){
            return new ResponseEntity<>("Check salary. Min value is 1.0", HttpStatus.BAD_REQUEST);
        }

        employeesService.updateEmployees(id, employeeDto);

        return new ResponseEntity<>("Employee updated", HttpStatus.OK);
    }


    // DELETE  -  delete employee by id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Employees employee = this.employeesService.getEmployeeById(id);

        if(employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        JobHistory jobHistory = jobHistoryService.getJobHistoryById(id);
        if(jobHistory != null){
            Integer num = jobHistory.getEmployee_id();
            LocalDate data = jobHistory.getStart_date();
            jobHistoryService.deleteJobHistory(num);
        }

        this.employeesService.deleteEmployee(id);

        return new ResponseEntity<>("Employee deleted", HttpStatus.ACCEPTED);
    }

}