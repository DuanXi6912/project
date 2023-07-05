package com.vissfot.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vissfot.project.Model.Regions;
import com.vissfot.project.Repository.RegionRepo;

@Service
public class RegionService {
    @Autowired
    private RegionRepo regionRepo;

    // Lấy danh sách regions trong database
    public List<Regions> getRegions(){
        return regionRepo.findAll();
    }
    // Lấy ra một Region bằng ID
    public Regions getRegionByID(int regionID){
        int index = getIndexByID(regionID);
        if(index != -1){
            return getRegions().get(index);
        }
        return null;
    }   

    public String createRegion(Regions region){
        int index = getIndexByName(region.getRegionName(), -1);
        if(index == -1){
            // Chưa tồn tại => Can Create
            regionRepo.save(region);
            return "Create New Region";
        }
        return "Fail For Create New Region";
    }

    public String updateRegion(Regions region){
        int index = getIndexByID(region.getRegionID());
        if(index != -1){
            // Tồn tại trong database
            // Kiểm tra các region trong bảng xem tên mới có trùng không
            int uniqueName = getIndexByName(region.getRegionName(), index);
            if(uniqueName == -1){
                // Chưa tồn tại tên => Unique == true
                regionRepo.save(region);
                return "Update Region ID = " + region.getRegionID();
            }
            return "Missinformation RegionName";
        }
        return "Fail For Update Region";
    }

    public String DeleteRegionByID(int regionID){
        Regions regionFound = getRegionByID(regionID);
        if(regionFound != null){
            regionRepo.delete(regionFound);
            return "Delete Region ID = " + regionID;
        }
        return "Fail For Delete Region";
    }
    
    // Supplement Method
    // Valid Region by ID
    private int getIndexByID(int regionID){
        List<Regions> regions = getRegions();
        int index = 0; 
        for(Regions regionFound : regions){
            if(regionID == regionFound.getRegionID()){
                return index;
            }
            index++;
        }
        return -1;
    } 
    // Valid Region by Name 
    private int getIndexByName(String regionName, int indexRegion){
        int index = 0;
        for(Regions region : getRegions()){
            if(indexRegion == index){
                index++;
                continue;
            } else {
                if(regionName.equals(region.getRegionName())){
                    return index;
                }
                index++;
            }
        }
        return -1; 
    }
    // Các hàm Valid đóng vai trò Exist ? Unique ?

}
