package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.DepartmentDto;
import com.endava.internship.dataCenter.model.Departments;
import com.endava.internship.dataCenter.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentsService implements DepartmentRepository {

    Departments department = new Departments();

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Departments.class)
            .buildSessionFactory();


    public Departments getDepartmentById(Integer id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        department = session.get(Departments.class, id);
        session.getTransaction().commit();

        System.out.println(department);

        log.info("IN DepartmentRepository getDepartmentById {}", id);
        return department;
    }

    public List<Departments> getAllDepartments(){
        List<Departments> departmentsList = new ArrayList<>();

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        departmentsList = session.createQuery("from Departments").getResultList();
        session.getTransaction().commit();

        log.info("IN DepartmentRepository getAllDepartments");

        return departmentsList;

    }


    public Departments addDepartment(DepartmentDto departmentDto){
        Departments department = new Departments();

        department.setDepartmentName(departmentDto.getDepartmentName());
//        department.setManagerId(departmentDto.getManagerId());
//        department.setLocationId(departmentDto.getLocationId());

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();

        log.info("Hibernate : IN DepartmentsService addDepartment id = {}", department.getDepartmentName());
        System.out.println("new department add : " + department);

        return department;
    }


    public Departments updateDepartment(Integer id, DepartmentDto departmentDto){
        //Departments department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("department not found"));
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        department = session.get(Departments.class, id);

        department.setDepartmentName(departmentDto.getDepartmentName());
//        department.setManagerId(departmentDto.getManagerId());
//        department.setLocationId(departmentDto.getLocationId());

        session.getTransaction().commit();

        log.info("Hibernate : IN DepartmentService updateDepartment with Id = {}", id);

        return department;
    }


    public void deleteDepartment(Integer id){

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        department = session.get(Departments.class, id);
        session.delete(department);
        session.getTransaction().commit();

        log.info("IN DepartmentRepository deleteDepartment delete department with Id = {}", id);
    }

}
