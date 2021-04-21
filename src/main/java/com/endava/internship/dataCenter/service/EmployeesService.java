package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeesService implements EmployeeRepository{

    Employees employee = new Employees();

//    @Autowired
//    private SessionFactory factory;

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employees.class)
            .buildSessionFactory();

    public Employees getEmployeeById(Integer id){
        //Employees employee = new Employees();

        //try{
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        employee = session.get(Employees.class, id);
        session.getTransaction().commit();

        System.out.println(employee);

        log.info("Hibernate : IN EmployeeService getEmployeeById = {}", id);
        return employee;
    }

    public List<Employees> getAllEmployees(){
        List<Employees> employeesList = new ArrayList<>();
        //Employees employee = new Employees();

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        employeesList = session.createQuery("from Employees").getResultList();
        session.getTransaction().commit();

        log.info("Hibernate : IN EmployeeService getAllEmployees");
        return employeesList;
    }


    public Employees addEmployee(EmployeeDto employeeDto){

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setSalary(employeeDto.getSalary());
        employee.setCommissionPct(employeeDto.getCommissionPct());
        employee.setJobId(employeeDto.getJobId());

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();

        log.info("Hibernate : IN EmployeeService addEmployee = ", employee);

        return employee;
    }


    public Employees updateEmployees(Integer id, EmployeeDto employeeDto){

        //Employees employee = new Employees();

//        Employees employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found employee"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setCommissionPct(employeeDto.getCommissionPct());

        log.info("Hibernate : IN EmployeeService updateEmployees = {}", id);

        return employee;
        //return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id){
        log.info("Hibernate : IN EmployeeService deleteEmployee = {}", id);
        //employeeRepository.deleteById(id);
    }

}
