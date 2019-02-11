package com.ss.touragency.entity;


import java.util.Date;

public class OrderDetails {

    private Long id;
    private Client client;
    private Hotel hotel;
    private Date beginDate;
    private Date endDate;

    public OrderDetails(Long id, Client client, Hotel hotel, Date beginDate, Date endDate) {
        this.id = id;
        this.client = client;
        this.hotel = hotel;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public OrderDetails() {
    }

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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", client=" + client +
                ", hotel=" + hotel +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
