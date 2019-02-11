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
                preparedStatement.setLong(2,city.getCountry().getIdCountry());
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public List<City> selectAll() throws SQLException {

        List<City> cityList = new ArrayList<>();

        String sql = "SELECT * FROM CITY";
        Statement statement = DBConnection.getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            City city = new City();
            city.setCityId( resultSet.getLong("idCity"));
            city.setCityName(resultSet.getString("cityName"));
            cityList.add(city);
        }

        return cityList;
    }

    @Override
    public City selectById(Long id) throws SQLException {
        String sql = "SELECT * FROM CITY WHERE idCity=" + "'" + id + "'";
        Statement statement = DBConnection.getDbConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        City city = null;

        while(resultSet.next()){
            city = new City();
            city.setCityId(resultSet.getLong("idCity"));
            city.setCityName(resultSet.getString("cityName"));
// ??       city.setCountry
        }

        return city;

    }

    @Override
    public void updateById(City city, Long id) {
        String sqlUpdate = "UPDATE city SET cityName=?" + " WHERE idCity=" + id + "";
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getDbConnection();
        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(sqlUpdate);

                preparedStatement.setString(1, city.getCityName());

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

