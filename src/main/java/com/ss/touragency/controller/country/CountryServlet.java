package com.ss.touragency.controller.country;

import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.entity.Country;
import com.ss.touragency.util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(PathToPage.COUNTRY_INFO)
public class CountryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Country> countryList = Context.getInstance().getCountryService().getCountryList(req);
        req.setAttribute("list", countryList);
        req.getRequestDispatcher("WEB-INF/views/country.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
