package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeesService employeesService;



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
        //return employeesService.getEmployeeJDBC(id);
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

//        First name and Last name - not to be null, empty or blank
//        Email - to match email format
//        Phone number - to start with 0 and and contain exactly 9 digits
//        Salary - min 1.0
    // POST  -  create new employee
    @PostMapping("/employees")
    public ResponseEntity<Employees> addEmployee(@RequestBody EmployeeDto employeesDto){


        if(employeesDto.getFirstName()=="null" || employeesDto.getLastName()==null){
            //return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Error in employee", HttpStatus.NOT_FOUND);
        }

        boolean checkEmail = employeesDto.getEmail().matches("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "("
                + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");

        boolean checkPhoneNumber = employeesDto.getPhoneNumber().matches("^0\\d{9}");
        System.out.println("email is = " + checkEmail + ", phone = " + checkPhoneNumber);

        Employees employees = this.employeesService.addEmployee(employeesDto);

        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }

    // PUT - update an existing employee
    @PutMapping("/employees/{id}")
    public Employees updateEmployeeById(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
        return employeesService.updateEmployees(id, employeeDto);
    }


    // DELETE  -  delete employee by id
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeesService.deleteEmployee(id);
    }

}
