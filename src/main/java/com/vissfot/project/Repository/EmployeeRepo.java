package com.vissfot.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vissfot.project.Model.Employees;

public interface EmployeeRepo extends JpaRepository<Employees,Integer>{
    
}
