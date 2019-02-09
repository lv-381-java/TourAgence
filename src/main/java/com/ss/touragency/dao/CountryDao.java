package com.ss.touragency.dao;

import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDao implements ICrudDao<Country> {

    @Override
    public void insert(Country country) {

        String insertCountry = "INSERT INTO country(countryName) VALUES(?)";
        Connection connection = DBConnection.getDbConnection();

        if(connection != null){

            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(insertCountry);

                preparedStatement.setString(1, country.getCountryName());
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Override
    public List<Country> selectAll() throws SQLException {
            List<Country> countryList = new ArrayList<>();

            String sql = "SELECT * FROM COUNTRY";
            Statement statement = DBConnection.getDbConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Country country = new Country();
                country.setIdCountry(resultSet.getInt("idCountry"));
                country.setCountryName(resultSet.getString("countryName"));

                countryList.add(country);
            }

            return countryList;
    }

    @Override
    public Country selectById(int id) throws SQLException {

        String sql = "SELECT * FROM COUNTRY WHERE idCountry=" + "'" + id + "'";
        Statement statement = DBConnection.getDbConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        Country country = null;

        while(resultSet.next()){
            country = new Country();

            country.setIdCountry(resultSet.getInt("idCountry"));
            country.setCountryName(resultSet.getString("countryName"));
        }

        return country;

    }

    @Override
    public void updateById(Country country, Long id) {

        String sqlUpdate = "UPDATE country SET countryName=?" + " WHERE idCountry=" + id + "";
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getDbConnection();
        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(sqlUpdate);

                preparedStatement.setString(1, country.getCountryName());

                preparedStatement.executeUpdate();

                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(Long id) {

        String deleteQuery = "DELETE FROM country WHERE idCountry=" + id + "";

        Statement statement;
        try {
            statement = DBConnection.getDbConnection().createStatement();

            statement.executeUpdate(deleteQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
