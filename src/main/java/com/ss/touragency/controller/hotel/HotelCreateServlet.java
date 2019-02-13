package com.ss.touragency.controller.hotel;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.constants.PathToJsp;
import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (PathToPage.CREATE_HOTEL)
public class HotelCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //TODO: login check
        if (request.getSession().getAttribute(Attribute.HOTEL) == null) {

            if (Context.getInstance().getCityService().createCity(request)) {
                response.sendRedirect(PathToPage.CREATE_HOTEL);
            } else {
                request.setAttribute(Attribute.ERROR, "Something went wrong! Please try again");
                request.getRequestDispatcher(PathToJsp.HOTEL_JSP).forward(request, response);
            }

        } else {
            request.setAttribute(Attribute.ERROR, "You are not login!");
            request.getRequestDispatcher(PathToJsp.LOGIN_JSP).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: login check
        if (request.getSession().getAttribute(Attribute.HOTEL_ID) == null ){
            request.getRequestDispatcher(PathToJsp.HOTEL_JSP).forward(request, response);
        }
        else {
            request.setAttribute(Attribute.ERROR, "You are not login!");
            request.getRequestDispatcher(PathToJsp.LOGIN_JSP).forward(request, response);
        }

    }
}
