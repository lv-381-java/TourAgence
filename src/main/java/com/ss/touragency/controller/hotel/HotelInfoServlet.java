package com.ss.touragency.controller.hotel;

import com.ss.touragency.constants.PathToJsp;
import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.entity.Hotel;
import com.ss.touragency.util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(PathToPage.HOTEL_INFO)
public class HotelInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Hotel> hotelList = Context.getInstance().getHotelService().getHotelList(req);
        req.setAttribute("hotel", hotelList);

        req.getRequestDispatcher(PathToJsp.HOTEL_JSP).forward(req, resp);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
