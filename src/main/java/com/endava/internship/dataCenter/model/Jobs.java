package com.endava.internship.dataCenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jobs")
public class Jobs {
    @Id
    //@SequenceGenerator(name="employees_seq",sequenceName="employees_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_seq")
    @Column(name = "job_id")
    private String jobId;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "min_salary")
    private Double minSalary;
    @Column(name = "max_salary")
    private Double maxSalary;

//    @OneToOne(mappedBy = "jobFromEmployee")
//    private Employees employees;
}
