package com.ss.touragency.service;

import com.ss.touragency.dao.CityDao;
import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.City;
import com.ss.touragency.entity.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CityService {

    //select country.countryName, city.cityName from country left join city on country.idCountry=city.Country_idCountry;

    public Map<Country, List<City>> selectAllCountrisWithCities() {
        Connection connection = DBConnection.getDbConnection();
        Map<Country, List<City>> countryCityMap = new HashMap<>();

        if (connection != null) {
            CountryDao countryDao = new CountryDao();
            CityDao cityDao = new CityDao();

            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

            List<Country> countryList = countryDao.selectAll();

            for (Country country : countryList) {

                List<City> cityList = new ArrayList<>();
                String selectCityByNameCountry = "select city.idCity, city.cityName, city.Country_idCountry from " +
                        "country join city on country.idCountry=city.Country_idCountry where countryName=?"; //left join

                try {
                    preparedStatement = connection.prepareStatement(selectCityByNameCountry);
                    preparedStatement.setString(1, country.getCountryName());
                    resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        City city = new City();
                        city.setCityId(resultSet.getLong("idCity"));
                        city.setCityName(resultSet.getString("cityName"));
                        cityList.add(city);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                countryCityMap.put(country, cityList);

            }
        }

        return countryCityMap;

    }

}
