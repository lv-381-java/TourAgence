package com.ss.touragency.controller.country;


import com.ss.touragency.constants.Attribute;
import com.ss.touragency.constants.PathToPage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(PathToPage.CITY_INFO)
public class CityServlet {

    void doGet(HttpServletRequest  request, HttpServletResponse response){
        if (request.getSession().getAttribute(Attribute.CITY))
    }
}
