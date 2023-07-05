package com.vissfot.project.DTO;

import com.vissfot.project.Model.Departments;
import com.vissfot.project.Model.Locations;

public class DepartmentDTO {
    private int departmentID;
    private String departmentName;
    private String locationInfor;
    
    public DepartmentDTO(Departments department){
        this.departmentID = department.getDepartmentID();
        this.departmentName = department.getDepartmentName();
        Locations location = department.getLocation();
        this.locationInfor = "[Address: " + location.getStreetAddress() + ", PostalCode: " + location.getPostalCode() + ", City: " + location.getCity() + "]"; 
    }
    
    public int getDepartmentID() {
        return this.departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocationInfor() {
        return this.locationInfor;
    }

    public void setLocationInfor(String locationInfor) {
        this.locationInfor = locationInfor;
    }

}
