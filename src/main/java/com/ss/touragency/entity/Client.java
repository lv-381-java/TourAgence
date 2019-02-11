package com.ss.touragency.entity;

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
                "idClient=" + idClient +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
