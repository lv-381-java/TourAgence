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

    public boolean updateCountry(HttpServletRequest request){
        boolean result = false;
        CountryDao countryDao = new CountryDao();

        if(request.getParameter(Attribute.COUNTRY_NAME) != null){
            Long countryId = Long.parseLong(request.getParameter(Attribute.COUNTRY_ID));
            Country country = countryDao.selectById(countryId);
            country.setCountryName(request.getParameter(Attribute.COUNTRY_NAME));
            countryDao.updateById(country, countryId);
            result = true;
        }
        return result;
    }
}
