package com.vissfot.project.DTO;

import com.vissfot.project.Model.Locations;

public class LocationDTO {
    private int locationID;
    private String address;
    private String postalCode;
    private String city;
    private String region;


    public LocationDTO(Locations location){
        this.locationID = location.getLocationID();
        this.address = location.getStreetAddress();
        this.postalCode = location.getPostalCode();
        this.city = location.getCity();
        this.region = "[ID: " + location.getRegion().getRegionID() + ", Name: " + location.getRegion().getRegionName() + " ]" ;
    }

    public int getLocationID() {
        return this.locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String regionStatus) {
        this.region = regionStatus;
    }

}
