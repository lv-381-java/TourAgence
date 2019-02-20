package com.ss.touragency.controller.orderdetails;

import com.ss.touragency.constants.PathToJsp;
import com.ss.touragency.constants.PathToPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathToPage.ORDER_DETAILS)
public class OrderDetailsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        request.getRequestDispatcher(PathToJsp.ORDER_DETAILS).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        request.getRequestDispatcher(PathToJsp.ORDER_DETAILS).forward(request, response);
    }

}