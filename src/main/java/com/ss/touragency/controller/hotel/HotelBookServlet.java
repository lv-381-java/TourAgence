package com.ss.touragency.controller.hotel;

import com.ss.touragency.constants.PathToJsp;
import com.ss.touragency.constants.PathToPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathToPage.HOTEL_BOOK)
public class HotelBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        request.getRequestDispatcher(PathToJsp.BOOK_HOTEL).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        request.getRequestDispatcher(PathToJsp.BOOK_HOTEL).forward(request, response);
    }

}
