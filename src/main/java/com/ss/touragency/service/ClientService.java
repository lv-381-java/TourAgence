package com.ss.touragency.service;

import com.ss.touragency.dao.ClientDao;
import com.ss.touragency.entity.Client;

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

}
