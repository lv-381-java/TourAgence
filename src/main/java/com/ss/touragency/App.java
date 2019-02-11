package com.ss.touragency;

import com.ss.touragency.dao.*;
import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.*;

import com.ss.touragency.dao.CityDao;
import com.ss.touragency.dao.ClientDao;
import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.dao.HotelDao;
import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.City;
import com.ss.touragency.entity.Client;
import com.ss.touragency.entity.Country;
import com.ss.touragency.entity.Hotel;
import com.ss.touragency.service.CityService;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws SQLException {

        CityService cityService = new CityService();
        Map<Country, List<City>> map = cityService.selectAllCountrisWithCities();

        for(Map.Entry<Country, List<City>> entry : map.entrySet()){

            Country cou = entry.getKey();
            List<City> cityList = entry.getValue();
            System.out.println(cou.getCountryName() + " : " + cityList);

        }


//        OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
//        System.out.println(orderDetailsDao.selectAll());

//        VisaDao visaDao = new VisaDao();
//        System.out.println(visaDao.selectAll());
//        System.out.println(visaDao.selectById(1L));

//        OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
//        System.out.println(orderDetailsDao.selectAll());
//        CountryDao countryDao = new CountryDao();

//        HotelDao hotelDao = new HotelDao();
//        System.out.println(hotelDao.selectById(3L));




    }
}
