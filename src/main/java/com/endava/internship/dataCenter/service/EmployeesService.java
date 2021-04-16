package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmployeesService {

    private final EmployeeRepository employeeRepository;

    public Employees addEmployee(EmployeeDto employeeDto){
        Employees employee = new Employees();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setSalary(employeeDto.getSalary());
        employee.setCommissionPct(employeeDto.getCommissionPct());
        //employee.setJobId(1);
        return employeeRepository.save(employee);
    }


    public Employees getEmployee(Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found employee"));
    }

    public List<Employees> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employees updateEmployees(Integer id, EmployeeDto employeeDto){
        Employees employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found employee"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setCommissionPct(employeeDto.getCommissionPct());
return employeeRepository.save(employee);
    }

// JDBC

    private static Connection connection(){
        Properties connectionProps = new Properties();
        connectionProps.put("user", "hr");
        connectionProps.put("password", "hr");

        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/PDB", connectionProps);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }

    public Employees getEmployeeJDBC(Integer id){
        Employees employee = new Employees();

        Connection c = connection();
        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = c.createStatement();

            String sql = "select * from employees where employee_id =" + id;

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Integer employee_id = rs.getInt("employee_id");
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                String hireDate = rs.getString("hire_date");
                LocalDate date =  rs.getDate("hire_date").toLocalDate();
                String jobId = rs.getString("job_id");
                Double salary = rs.getDouble("salary");
                Double commission_pct = rs.getDouble("commission_pct");
                Integer managerId = rs.getInt("manager_id");
                Integer departmentId = rs.getInt("department_id");
                System.out.println("employee from JDBC = { "
                                        + employee_id + ", "
                                        + firstname + ", "
                                        + lastname + ", "
                                        + email + ", "
                                        + phoneNumber + ", "
                                        + hireDate + ", "
                                        + salary + ", "
                                        + commission_pct + ", "
                                        + jobId + " }");
                employee.setEmployeeId(employee_id);
                employee.setFirstName(firstname);
                employee.setLastName(lastname);
                employee.setEmail(email);
                employee.setPhoneNumber(phoneNumber);
                employee.setSalary(salary);
                employee.setCommissionPct(commission_pct);
                employee.setHireDate(date);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            };
            try {
                if (c != null) c.close();
            } catch (Exception e) {
                e.printStackTrace();
            };

        }
        return employee;
    }


}
