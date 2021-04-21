package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeesService implements EmployeeRepository{

    //private final EmployeeRepository employeeRepository;

//    @Autowired
//    private SessionFactory sessionFactory;

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employees.class)
            .buildSessionFactory();

    public Employees getEmployeeById(Long id){

        Employees employee = new Employees();

        String query = "SELECT * FROM employees where employee_id=150";
        //sessionFactory.getCurrentSession().beginTransaction(). .createQuery(query);

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        employee = session.get(Employees.class, 150);
        session.getTransaction().commit();

        log.info("Hibernate : IN EmployeeRepository getEmployeeById {}", id);
        return employee;
        //return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found employee"));
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

        log.info("Hibernate : IN EmployeeRepository addEmployee", employee);

        return employee;
    }


    public List<Employees> getAllEmployees(){
        log.info("IN EmployeeRepository getAllEmployees");
        return null;
        //return employeeRepository.findAll();
    }

    public Employees updateEmployees(Long id, EmployeeDto employeeDto){
        log.info("Hibernate : IN EmployeeRepository updateEmployees {}", id);
        Employees employee = new Employees();

//        Employees employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found employee"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setCommissionPct(employeeDto.getCommissionPct());

        return employee;
        //return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        log.info("Hibernate : IN EmployeeRepository deleteEmployee {}", id);
        //employeeRepository.deleteById(id);
    }

}
