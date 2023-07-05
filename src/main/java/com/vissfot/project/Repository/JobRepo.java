package com.vissfot.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vissfot.project.Model.Jobs;

public interface JobRepo extends JpaRepository<Jobs, Integer>{
    
}
