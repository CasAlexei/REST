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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String jobId;
    private String jobTitle;
    private Double minSalary;
    private Double maxSalary;

//    @OneToOne(mappedBy = "jobFromEmployee")
//    private Employees employees;
}
