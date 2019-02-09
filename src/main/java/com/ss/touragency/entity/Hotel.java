package com.ss.touragency.entity;

public class Hotel {

    private Long hotelId;
    private String hotelName;
    private City city;
    private int availableCount;

    public Hotel(Long hotelId, String hotelName, City city, int availableCount) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.city = city;
        this.availableCount = availableCount;
    }

    public Hotel() {
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", city=" + city +
                ", availableCount=" + availableCount +
                '}';
    }
}
