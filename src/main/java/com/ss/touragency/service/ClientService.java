package com.ss.touragency.service;

import com.ss.touragency.dao.ClientDao;
import com.ss.touragency.entity.Client;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

public class ClientService {

    public boolean validationClient(HttpServletRequest request)throws NullPointerException{

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.findClientByNameAndPhone(request.getParameter("username"), request.getParameter("password"));

        if(!client.equals(null)){
            return true;
        }

        return false;
    }

    public void registrationClient(HttpServletRequest request){

        Client client = new Client();
        client.setClientName(request.getParameter("name"));
        client.setClientSurname(request.getParameter("surname"));
        client.setPhoneNumber(request.getParameter("phone"));
        client.setClientLogin(request.getParameter("login"));
        client.setClientPassword(request.getParameter("password"));

        ClientDao clientDao = new ClientDao();
        clientDao.insert(client);
    }

}
