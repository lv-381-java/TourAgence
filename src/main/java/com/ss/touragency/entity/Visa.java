package com.ss.touragency.entity;

public class Visa {

    private Long id;
    private Client client;
    private Country country;

    public Visa() {
    }

    public Visa(Client client, Country country) {
        this.client = client;
        this.country = country;
    }

    public Visa(Long id, Client client, Country country) {
        this.id = id;
        this.client = client;
        this.country = country;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Visa{" +
                "id=" + id +
                ", client=" + client +
                ", country=" + country +
                '}';
    }
}
