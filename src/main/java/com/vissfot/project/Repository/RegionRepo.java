package com.vissfot.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vissfot.project.Model.Regions;

public interface RegionRepo extends JpaRepository<Regions, Integer>{
    
}
