package com.ss.touragency.controller.country;


import com.ss.touragency.constants.Attribute;
import com.ss.touragency.constants.PathToJsp;
import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.util.Context;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathToPage.CITY_INFO)
public class CityServlet {

    void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //TODO: login check
        if (request.getSession().getAttribute(Attribute.CITY) == null) {

            if (Context.getInstance().getCityService().createCity(request)) {
                response.sendRedirect(PathToPage.CREATE_CITY);
            } else {
                request.setAttribute(Attribute.ERROR, "Something went wrong! Please try again");
                request.getRequestDispatcher(PathToJsp.HOME_JSP);
            }

        } else {
            request.setAttribute(Attribute.ERROR, "You are not login!");
//            request.getRequestDispatcher(PathToJsp.LOGIN_JSP);
        }
    }


}
