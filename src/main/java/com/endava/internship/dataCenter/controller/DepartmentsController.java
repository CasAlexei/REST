package com.endava.internship.dataCenter.controller;

import com.endava.internship.dataCenter.model.DepartmentDto;
import com.endava.internship.dataCenter.model.Departments;
import com.endava.internship.dataCenter.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    // GET(id)  -  get department by name
    @GetMapping("/departments/{id}")
    public ResponseEntity<Departments> getDepartment(@PathVariable Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Departments department = this.departmentsService.getDepartmentById(id);

        if(department == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    //  GET  -  list of all departments
    @GetMapping("/departments")
    public ResponseEntity<List<Departments>> getAllDepartments(){
        List<Departments> departmentsList = this.departmentsService.getAllDepartments();

        if(departmentsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departmentsList, HttpStatus.OK);
    }

    // POST  -  create new department
    @PostMapping("/departments")
    public ResponseEntity<String> addDepartment(@RequestBody DepartmentDto departmentDto){

        //  Name - not to be null, empty or blank
        String checkName = departmentDto.getDepartmentName();
        if(checkName == null){
            return new ResponseEntity<>("Name - not to be null", HttpStatus.BAD_REQUEST);
        }
        if(checkName.trim().isEmpty()){
            return new ResponseEntity<>("Name - not to be empty or blank", HttpStatus.BAD_REQUEST);
        }
        Departments department = this.departmentsService.addDepartment(departmentDto);

        return new ResponseEntity<>("Department added", HttpStatus.CREATED);
    }


    // PUT - update an existing department
    @PutMapping("/departments/{id}")
    public ResponseEntity<String> getDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto){
        //  Name - not to be null, empty or blank
        String checkName = departmentDto.getDepartmentName();
        if(checkName == null){
            return new ResponseEntity<>("Name - not to be null", HttpStatus.BAD_REQUEST);
        }
        if(checkName.trim().isEmpty()){
            return new ResponseEntity<>("Name - not to be empty or blank", HttpStatus.BAD_REQUEST);
        }

        departmentsService.updateDepartment(id, departmentDto);

        return new ResponseEntity<>("Department updated", HttpStatus.OK);
    }

    // DELETE  -  delete department by id
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        departmentsService.deleteDepartment(id);

        Departments department = this.departmentsService.getDepartmentById(id);

        if(department == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Department deleted", HttpStatus.NO_CONTENT);
    }
}
