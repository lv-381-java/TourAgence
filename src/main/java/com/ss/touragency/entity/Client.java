package com.ss.touragency.entity;

public class Client {
    private int idClient;
    private String ClientName;
    private String ClientSurname;
    private int phoneNumber;

    public Client() {
    }

    public Client(int idClient, String clientName, String clientSurname, int phoneNumber) {
        this.idClient = idClient;
        ClientName = clientName;
        ClientSurname = clientSurname;
        this.phoneNumber = phoneNumber;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getClientSurname() {
        return ClientSurname;
    }

    public void setClientSurname(String clientSurname) {
        ClientSurname = clientSurname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", ClientName='" + ClientName + '\'' +
                ", ClientSurname='" + ClientSurname + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
