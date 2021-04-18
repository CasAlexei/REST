package com.endava.internship.dataCenter.service;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Jobs;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import javafx.util.converter.LocalDateStringConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
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
        employee.setJobId("SA_REP");
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

// JDBC ------------------------------------------------------------------

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

    public Employees addEmployeeJDBC(EmployeeDto employeeDto){
        Employees employee = new Employees();

        Connection c = connection();
        Statement stmt = null;
        ResultSet resultSet = null;

        try{
            stmt = c.createStatement();

            ;
            String queryInsertNewEmployee = "insert into employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct) values (?, ?, ?, ?, ?, ?, ? ,? ,?)";
            PreparedStatement preparedStatement = c.prepareStatement(queryInsertNewEmployee);

            String getIdNext = "select count(employee_id)+1 as count from employees";
            resultSet = stmt.executeQuery(getIdNext);
            resultSet.next();

            int newId = resultSet.getInt("count")+100;  // make next id value for employee_id
            newId++;

            preparedStatement.setInt(1, newId);                             // employee_id
            preparedStatement.setString(2, employeeDto.getFirstName());     // first_name
            preparedStatement.setString(3, employeeDto.getLastName());      // last_name
            preparedStatement.setString(4, employeeDto.getEmail());         // email
            preparedStatement.setString(5, employeeDto.getPhoneNumber());   // phone_number
            preparedStatement.setDate(6, java.sql.Date.valueOf(employeeDto.getHireDate().toString()));   // hire_date
            preparedStatement.setString(7, employeeDto.getJobId());         // job_id
            preparedStatement.setDouble(8, employeeDto.getSalary());        // salary
            preparedStatement.setDouble(9, employeeDto.getCommissionPct()); // commission_pct

            // create new employee
            employee.setEmployeeId(newId);
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employeeDto.getEmail());
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
            employee.setSalary(employeeDto.getSalary());
            employee.setCommissionPct(employeeDto.getCommissionPct());
            employee.setHireDate(employeeDto.getHireDate());
            employee.setJobId(employeeDto.getJobId());

            preparedStatement.executeUpdate();

            System.out.println("new employee add");

//            String qu = "insert into employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct)" +
//                    "values (260, 'AAA11', 'BBB11', 'CCC12', '129268', TO_DATE('1991/06/07','yyyy/mm/dd'), 'SA_REP', 10000.0, 0.3)";
//            int countOfInsert = stmt.executeUpdate(queryInsertNewEmployee);

//            System.out.println("number of insert = " +countOfInsert);

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {if (resultSet != null) resultSet.close();} catch (Exception e) {e.printStackTrace();};
            try {if (stmt != null) stmt.close();} catch (Exception e) {e.printStackTrace();};
            try {if (c != null) c.close();} catch (Exception e) {e.printStackTrace();};
        }
        return employee;
    }

    public Employees getEmployeeJDBC(Integer id){
        Employees employee = new Employees();
        Jobs jobs = new Jobs();

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
                System.out.println("employee  = { "
                                        + employee_id + ", "
                                        + firstname + ", "
                                        + lastname + ", "
                                        + email + ", "
                                        + phoneNumber + ", "
                                        + hireDate + ", "
                                        + salary + ", "
                                        + commission_pct + ", "
                                        + jobId + ", "
                                        + departmentId + ", "
                                        + managerId + " }");
                employee.setEmployeeId(employee_id);
                employee.setFirstName(firstname);
                employee.setLastName(lastname);
                employee.setEmail(email);
                employee.setPhoneNumber(phoneNumber);
                employee.setSalary(salary);
                employee.setCommissionPct(commission_pct);
                employee.setHireDate(date);
                employee.setJobId(jobId);
//                employee.setManagerId(managerId);
//                employee.setDepartmentId(departmentId);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();};
            try {if (stmt != null) stmt.close();} catch (Exception e) {e.printStackTrace();};
            try {if (c != null) c.close();} catch (Exception e) {e.printStackTrace();};
        }
        return employee;
    }


}
