package com.vissfot.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vissfot.project.Model.Locations;
import com.vissfot.project.Model.Regions;
import com.vissfot.project.Service.RegionService;

@RestController
public class RegionController {
    
    @Autowired
    private RegionService regionService;


    @GetMapping("/regions")
    public List<Regions> getRegions(){
        return regionService.getRegions();
    }

    @GetMapping("/regions/{regionID}/locations")
    public List<Locations> getLocations(@PathVariable int regionID){
        return regionService.getRegionByID(regionID).getLocations();
    }
    @GetMapping("/regions/{regionID}")
    public Regions getRegionByID(@PathVariable int regionID){
        return regionService.getRegionByID(regionID);
        
    }
    @PostMapping("/regions")
    public String createRegion(@RequestBody Regions region){
        return regionService.createRegion(region);
    }
    @PutMapping("/regions")
    public String updateRegion(@RequestBody Regions region){
        return regionService.updateRegion(region);
    }
    @DeleteMapping("/regions/{regionID}")
    public String deleteRegionByID(@PathVariable int regionID){
        return regionService.DeleteRegionByID(regionID);
    }

}
