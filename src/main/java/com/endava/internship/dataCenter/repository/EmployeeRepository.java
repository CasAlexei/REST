package com.endava.internship.dataCenter.repository;

import com.endava.internship.dataCenter.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
