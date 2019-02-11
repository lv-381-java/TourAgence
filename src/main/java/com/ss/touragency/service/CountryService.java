package com.ss.touragency.service;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.entity.Country;

import javax.servlet.http.HttpServletRequest;

public class CountryService {

    public boolean createCountry(HttpServletRequest request) {
        boolean result = false;

        String countryName = request.getParameter(Attribute.COUNTRY_NAME);
        if (countryName != null && !countryName.isEmpty()) {
            CountryDao countryDao = new CountryDao();
            Country country = new Country(-1L, countryName);
            countryDao.insert(country);
            result = true;
        }

        return result;
    }
}
