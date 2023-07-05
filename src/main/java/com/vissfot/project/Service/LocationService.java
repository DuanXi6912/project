package com.vissfot.project.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vissfot.project.DTO.LocationDTO;
import com.vissfot.project.Model.Locations;
import com.vissfot.project.Repository.LocationRepo;

@Service
public class LocationService {
    @Autowired
    private LocationRepo locationRepo;

    // DTO
    public List<LocationDTO> getLocationDTOs(){
        List<LocationDTO> locationDTOs = new ArrayList<>();
        for(Locations location : getLocations()){
            LocationDTO locationDTO = new LocationDTO(location);
            locationDTOs.add(locationDTO);
        }
        return locationDTOs;
    }

    public LocationDTO getLocationDTOByID(int locationID){
        Locations locationFound = getLocationByID(locationID);
        if(locationFound != null){
            LocationDTO locationDTO = new LocationDTO(locationFound);
            return locationDTO;
        }
        return null;
    }

    public String createLocation(Locations location){
        boolean valid = uniqueCheck(location.getStreetAddress(), location.getPostalCode(), location.getCity(), -1);
        if(valid){
            // Có thể khởi tạo do trước có trước đó
            locationRepo.save(location);
            return "Create New Location";
        }
        return "Fail For Create New Location";
    } 

    public String updateLocation(Locations location){
        int index = getIndexByID(location.getLocationID());
        if(index != -1){
            // Location đã tồn tại => can Update
            // Valid Unique location mới
            boolean valid = uniqueCheck(location.getStreetAddress(), location.getPostalCode(), location.getCity(), location.getLocationID());
            if(valid){
                locationRepo.save(location);
                return "Update Location";
            }
            return "Missinformation UniqueCheck";
        }
        return "Fail For Update Location";
    }

    public String deleteLocationByID(int locationID){
        Locations locationFound = getLocationByID(locationID);
        if(locationFound != null){
            locationRepo.delete(locationFound);
            return "Delete Location ID = " + locationID;
        }
        return "Fail For Delete Location";
    }

    // Supplement Method
    private List<Locations> getLocations(){
        return locationRepo.findAll();
    }

    private Locations getLocationByID(int locationID){
        int index = getIndexByID(locationID);
        if(index != -1){
            return getLocations().get(index);
        }
        return null;
    }

    private int getIndexByID(int locationID){
        List<Locations> locations = getLocations();
        int index = 0;
        for(Locations locationFound : locations){
            if(locationID == locationFound.getLocationID()){
                return index;
            }
            index++;
        }
        return -1;
    }

    private boolean uniqueCheck(String street, String postalCode, String city, int locationID){
        List<Locations> locations = getLocations();
        for(Locations locationFound : locations){
            if(locationID == locationFound.getLocationID()){
                continue;
            }
            if(street.equals(locationFound.getStreetAddress())
               && postalCode.equals(locationFound.getPostalCode())
               && city.equals(locationFound.getCity())){
                return false;
            }
        }
        return true;
    }

}
