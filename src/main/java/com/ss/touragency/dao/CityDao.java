package com.ss.touragency.dao;

import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.Country;
import com.ss.touragency.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements ICrudDao<City> {

    @Override
    public void insert(City city) {
        String insertCountry = "INSERT INTO city(cityName,Country_idCountry) VALUES(?,?)";
        Connection connection = DBConnection.getDbConnection();

        if (connection != null) {

            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(insertCountry);

                preparedStatement.setString(1, city.getCityName());
                preparedStatement.setLong(2, city.getCountry().getIdCountry());
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<City> selectAll() {

        List<City> cityList = new ArrayList<>();

        String sql = "SELECT * FROM CITY";
        Statement statement = null;
        try {
            statement = DBConnection.getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                City city = new City();
                city.setCityId(resultSet.getLong("idCity"));
                city.setCityName(resultSet.getString("cityName"));
                cityList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cityList;
    }

    @Override
    public City selectById(Long id) {
        String sql = "SELECT * FROM CITY WHERE idCity=" + "'" + id + "'";
        Statement statement = null;

        ResultSet resultSet = null;
        City city = null;
        try {
            statement = DBConnection.getDbConnection().createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                city = new City();
                city.setCityId(resultSet.getLong("idCity"));
                city.setCityName(resultSet.getString("cityName"));
// ??       city.setCountry
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return city;

    }

    @Override
    public void updateById(City city, Long id) {
        String sqlUpdate = "UPDATE city SET cityName=?,Country_idCountry=?" + " WHERE idCity=" + id + "";
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getDbConnection();
        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(sqlUpdate);

                preparedStatement.setString(1, city.getCityName());
                preparedStatement.setLong(2, city.getCountry().getIdCountry());

                preparedStatement.executeUpdate();

                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(Long id) {
//        String deleteQuery = "DELETE FROM city WHERE idCity=" + id + "";
//
//        Statement statement;
//        try {
//            statement = DBConnection.getDbConnection().createStatement();
//
//            statement.executeUpdate(deleteQuery);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}


