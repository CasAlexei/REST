package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.DepartmentDto;
import com.endava.internship.dataCenter.model.Departments;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.repository.DepartmentRepository;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentsService implements DepartmentRepository{

    private final Departments department = new Departments();

    @Override
    public Departments getDepartmentById(Integer id) {
        return null;
    }

    @Override
    public Departments addDepartment(DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public List<Departments> getAllDepartments() {
        return null;
    }

    @Override
    public Departments updateDepartment(Integer id, DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public void deleteDepartment(Integer id) {

    }
/*

    public Departments getDepartmentById(Integer id){
        log.info("IN DepartmentRepository getDepartmentById {}", id);
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }


    public Departments addDepartment(DepartmentDto departmentDto){
        Departments department = new Departments();

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setManagerId(departmentDto.getManagerId());
        department.setLocationId(departmentDto.getLocationId());

        log.info("IN DepartmentRepository addEmployee", department);
        return departmentRepository.save(Departments.from(departmentDto));
    }


    public List<Departments> getAllDepartments(){
        log.info("IN DepartmentRepository getAllDepartments");
        return departmentRepository.findAll();
    }


    public Departments updateDepartment(Integer id, DepartmentDto departmentDto){
        Departments department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("department not found"));
        department.setDepartmentName(departmentDto.getDepartmentName());
        return departmentRepository.save(department);
    }


    public void deleteDepartment(Integer id){
        log.info("IN DepartmentRepository deleteDepartment {}", id);
        departmentRepository.deleteById(id);
    }
*/

}
