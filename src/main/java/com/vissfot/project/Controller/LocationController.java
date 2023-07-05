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

import com.vissfot.project.DTO.LocationDTO;
import com.vissfot.project.Model.Locations;
import com.vissfot.project.Service.LocationService;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List<LocationDTO> getLocations(){
        return locationService.getLocationDTOs();
    }
    
    @GetMapping("/locations/{locationID}")
    public LocationDTO getLocationDTOByID(@PathVariable int locationID){
        return locationService.getLocationDTOByID(locationID);
    }

    @PostMapping("/locations")
    public String createLocation(@RequestBody Locations location){
        return locationService.createLocation(location);
    }

    @PutMapping("/locations")
    public String updateLocation(@RequestBody Locations location){
        return locationService.updateLocation(location);
    }
  
    @DeleteMapping("/locations/{locationID}")
    public String deleteLocationByID(@PathVariable int locationID){
        return locationService.deleteLocationByID(locationID);
    }
    
}
