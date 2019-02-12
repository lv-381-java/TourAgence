package com.ss.touragency;

import com.ss.touragency.entity.City;

import com.ss.touragency.entity.Country;
import com.ss.touragency.service.CityService;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws SQLException {

        CityService cityService = new CityService();
        Map<Country, List<City>> map = cityService.selectAllCountrisWithCities();

        for (Map.Entry<Country, List<City>> entry : map.entrySet()) {

            Country cou = entry.getKey();
            List<City> cityList = entry.getValue();
            System.out.println(cou.getCountryName() + " : " + cityList);

        }
    }
}
