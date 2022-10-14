package com.schneit.parksproject.parks;

import com.schneit.parksproject.addresses.AddressModel;

public class ParkModel {
    private String parkName;
    private String parkDescription;
    private String designation;
    private String directionsInfo;
    private String directionUrl;
    private String parkUrl;
    private String weatherInfo;
    private String fullName;
    private Double latitude;
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    private AddressModel address;

    public String getParkName() {
        return parkName;
    }

    public String getParkDescription() {
        return parkDescription;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDirectionsInfo() {
        return directionsInfo;
    }

    public String getDirectionUrl() {
        return directionUrl;
    }

    public String getParkUrl() {
        return parkUrl;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public Double getLatidute() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getFullName() { return fullName; }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public void setParkDescription(String parkDescription) {
        this.parkDescription = parkDescription;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDirectionsInfo(String directionsInfo) {
        this.directionsInfo = directionsInfo;
    }

    public void setDirectionUrl(String directionUrl) {
        this.directionUrl = directionUrl;
    }

    public void setParkUrl(String parkUrl) {
        this.parkUrl = parkUrl;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public void setLatidute(Double latidute) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setFullName(String fullName) { this.fullName = fullName; }
}
