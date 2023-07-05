package com.vissfot.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vissfot.project.Model.Departments;

public interface DepartmentRepo extends JpaRepository<Departments, Integer> {
    
}
