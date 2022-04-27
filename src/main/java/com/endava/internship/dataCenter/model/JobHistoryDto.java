package com.endava.internship.dataCenter.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobHistoryDto {
    private Integer employee_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private String job_id;
    private Integer department_id;
}
