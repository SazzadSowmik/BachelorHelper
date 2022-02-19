package com.example.bachelorhelper;

public class ApartmentInfo {
    private String city, area, address;

    public ApartmentInfo(){

    }

    public ApartmentInfo(String city, String area, String address) {
        this.city = city;
        this.area = area;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
