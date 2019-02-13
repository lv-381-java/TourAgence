package com.ss.touragency.controller.country;

import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.entity.Country;
import com.ss.touragency.service.CountryService;
import com.ss.touragency.util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathToPage.COUNTRY_INFO)
public class CountryInfoServlet extends HttpServlet {
    public static final String

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = Context.getInstance().getCountryService().getCountry(request).getCountryName();
        request.setAttribute("list", country);

        request.getRequestDispatcher("WEB-INF/views/country.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
