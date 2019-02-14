package com.ss.touragency.service;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.dao.ClientDao;
import com.ss.touragency.entity.Client;

import javax.servlet.http.HttpServletRequest;

public class ClientService {

    public boolean validationClient(HttpServletRequest request) throws NullPointerException {

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.findClientByNameAndPhone(request.getParameter("username"), request.getParameter("password"));

        if (!client.equals(null)) {
            return true;
        }

        return false;
    }

    public Client getClient(HttpServletRequest request) {
        ClientDao clientDao = new ClientDao();

        if (request.getSession().getAttribute(Attribute.CLIENT_ID) == null
                && isExistItem(Long.parseLong((String) request.getSession().getAttribute(Attribute.CLIENT_ID)))){

            Long id = Long.parseLong((String) request.getSession().getAttribute(Attribute.CLIENT_ID));
            clientDao.selectById(id);
        }
        return null;
    }

    private boolean isExistItem(Long id) {
        boolean result = false;
        try {
            ClientDao clientDao = new ClientDao();
            clientDao.selectById(id);
            result = true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return result;
    }

}
