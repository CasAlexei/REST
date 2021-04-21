package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.DepartmentDto;
import com.endava.internship.dataCenter.model.Departments;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentsService {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Departments.class)
            .buildSessionFactory();


    public Departments getDepartmentById(Integer id){
        log.info("IN DepartmentRepository getDepartmentById {}", id);
        return null;
    }


    public Departments addDepartment(DepartmentDto departmentDto){
        Departments department = new Departments();

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setManagerId(departmentDto.getManagerId());
        department.setLocationId(departmentDto.getLocationId());

        log.info("IN DepartmentRepository addEmployee", department);
        return department;
    }


    public List<Departments> getAllDepartments(){
        log.info("IN DepartmentRepository getAllDepartments");
        return null;
    }


    public Departments updateDepartment(Integer id, DepartmentDto departmentDto){
        //Departments department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("department not found"));
        Departments department = new Departments();

        //department.setDepartmentName(departmentDto.getDepartmentName());

        return department;
    }


    public void deleteDepartment(Integer id){
        log.info("IN DepartmentRepository deleteDepartment {}", id);
        //departmentRepository.deleteById(id);
    }

}
