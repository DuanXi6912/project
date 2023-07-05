package com.vissfot.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vissfot.project.Model.Dependents;

public interface DependentRepo extends JpaRepository<Dependents, Integer> {
    
}
