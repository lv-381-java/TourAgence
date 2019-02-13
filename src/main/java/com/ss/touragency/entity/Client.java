package com.ss.touragency.entity;

import java.util.Objects;

public class Client {
    private Long idClient;
    private String clientName;
    private String clientSurname;
    private String phoneNumber;

    public Client() {
    }

    public Client(String clientName, String clientSurname, String phoneNumber) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.phoneNumber = phoneNumber;
    }

    public Client(Long idClient, String clientName, String clientSurname, String phoneNumber) {
        this.idClient = idClient;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.phoneNumber = phoneNumber;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient.equals(client.idClient) &&
                clientName.equals(client.clientName) &&
                clientSurname.equals(client.clientSurname) &&
                phoneNumber.equals(client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, clientName, clientSurname, phoneNumber);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
