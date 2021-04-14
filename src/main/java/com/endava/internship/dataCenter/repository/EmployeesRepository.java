package com.endava.internship.dataCenter.repository;

import com.endava.internship.dataCenter.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

}
