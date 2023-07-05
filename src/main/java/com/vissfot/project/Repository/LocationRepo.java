package com.vissfot.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vissfot.project.Model.Locations;

public interface LocationRepo extends JpaRepository<Locations, Integer>{
    
}
