package com.endava.internship.dataCenter.repository;

import com.endava.internship.dataCenter.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, Integer> {

}
