package com.ss.touragency;


import com.ss.touragency.dao.CityDao;
import com.ss.touragency.entity.City;
import com.ss.touragency.entity.Country;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws SQLException {

        CityDao cityDao = new CityDao();
        Map<Country, List<City>> map = cityDao.selectAllCountrisWithCities();

        for (Map.Entry<Country, List<City>> entry : map.entrySet()) {

            Country cou = entry.getKey();
            List<City> cityList = entry.getValue();
            System.out.println(cou.getCountryName() + " : " + cityList);

        }
    }
}
