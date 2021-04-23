package com.endava.internship.dataCenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_history")
public class JobHistory {
    @EmbeddedId
    private JobHistoryId jobHistoryId;
    @Column(insertable = false, updatable = false)
    private Integer employee_id;
    @Column(insertable = false, updatable = false)
    private LocalDate start_date;
    private LocalDate end_date;
    private String job_id;
    private Integer department_id;

//    @OneToMany(mappedBy = "jobHistory")
//    private List<Employees> employees;

    public static JobHistory from(JobHistoryDto jobHistoryDto) {
        return builder()
                .employee_id(jobHistoryDto.getEmployee_id())
                .start_date(jobHistoryDto.getStart_date())
                .end_date(jobHistoryDto.getEnd_date())
                .job_id(jobHistoryDto.getJob_id())
                .department_id(jobHistoryDto.getDepartment_id())
                .build();
    }
}
