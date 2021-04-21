package com.endava.internship.dataCenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employees {

    @Id
    @SequenceGenerator(name="employees_seq",sequenceName="employees_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_seq")
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name ="first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    @Column(name ="email")
    private String email;
    @Column(name ="phone_number")
    private String phoneNumber;
    @Column(name ="hire_date")
    private LocalDate hireDate;
    @Column(name ="salary")
    private Double salary;
    @Column(name ="commission_pct")
    private Double commissionPct;
    @Column(name ="job_id")
    private String jobId;

//    private Integer managerId;
//    private Integer departmentId;

//    @OneToOne(fetch = FetchType.LAZY)   //fetch = FetchType.LAZY
//    @JoinColumn(name="job_id")
//    private Jobs jobFromEmployee;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="department_id")
//    private Departments departmentDetail;



    public static Employees from(EmployeeDto employeeDto) {
        return builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .phoneNumber(employeeDto.getPhoneNumber())
                .hireDate(employeeDto.getHireDate())
                .salary(employeeDto.getSalary())
                .commissionPct(employeeDto.getCommissionPct())
                .jobId(employeeDto.getJobId())
                .build();
        }
}
