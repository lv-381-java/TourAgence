package com.ss.touragency.entity;

public class OrderDetails {

    private Long id;
    private Client client;
    private Hotel hotel;
    private String beginDate;
    private String endDate;

    public OrderDetails(Long id, Client client, Hotel hotel, String beginDate, String endDate) {
        this.id = id;
        this.client = client;
        this.hotel = hotel;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public OrderDetails() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", client=" + client +
                ", hotel=" + hotel +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
