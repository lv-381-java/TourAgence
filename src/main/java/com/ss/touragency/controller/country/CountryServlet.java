package com.ss.touragency.controller.country;

import com.ss.touragency.constants.PathToPage;
import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.entity.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(PathToPage.CREATE_COUNTRY)

public class CountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CountryDao countryDao = new CountryDao();
        List<Country> countryList = countryDao.selectAll();
        req.setAttribute("list", countryList);
        req.getRequestDispatcher("WEB-INF/views/country.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
