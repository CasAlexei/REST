package com.endava.internship.dataCenter.repository;

import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.model.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {
}
