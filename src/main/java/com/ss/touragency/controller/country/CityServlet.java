package com.ss.touragency.controller.country;


import com.ss.touragency.constants.Attribute;
import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.util.Context;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathToPage.CITY_INFO)
public class CityServlet {

    void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute(Attribute.CITY) == null) {
            if (Context.getInstance().getCityService().createCity(request)) {
                response.sendRedirect(PathToPage.CREATE_CITY);
            }
        }
    }
}
