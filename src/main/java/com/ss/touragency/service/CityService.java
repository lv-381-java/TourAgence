package com.ss.touragency.service;

import com.ss.touragency.constants.Attribute;
import com.ss.touragency.dao.CityDao;
import com.ss.touragency.entity.City;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CityService {

    public boolean createCity(HttpServletRequest request) {
        boolean result = false;

        String cityName = request.getParameter(Attribute.CITY_NAME);

        if (cityName != null && !cityName.isEmpty()) {
            CityDao cityDao = new CityDao();
            City city = new City(1L, cityName);
            cityDao.insert(city);
            result = true;
        }

        return result;
    }

    public City getCity(HttpServletRequest request) {
        CityDao cityDao = new CityDao();

        if (request.getSession().getAttribute(Attribute.CITY_ID) != null &&
                isExistItem(Long.parseLong((String) request.getSession().getAttribute(Attribute.CITY_ID)))) {
            Long cityId = Long.parseLong( (String) request.getSession().getAttribute(Attribute.CITY_ID));

            return cityDao.selectById(cityId);
        }
        return null;
    }

    private boolean isExistItem(Long id) {
        boolean result = false;
        try {
            CityDao cityDao = new CityDao();
            cityDao.selectById(id);
            result = true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<City> getCityList(HttpServletRequest request){

        CityDao cityDao = new CityDao();
        List<City> cityList = cityDao.selectAll();

        return cityList;
    }


}
