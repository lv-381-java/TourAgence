package com.ss.touragency.controller.client;

import com.ss.touragency.constants.PathToJsp;
import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.entity.Client;
import com.ss.touragency.util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathToPage.USER_INFO)
public class ClientInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = Context.getInstance().getClientService().getClient(request);
        request.setAttribute("client", client);
        request.getRequestDispatcher(PathToJsp.CLIENT_JSP).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}