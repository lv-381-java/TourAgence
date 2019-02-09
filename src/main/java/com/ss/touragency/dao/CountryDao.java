package com.ss.touragency.dao;

import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDao implements ICrudDao<Country> {

    @Override
    public void create(Country country) {

    }

    @Override
    public List<Country> getAll() throws SQLException {
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
    public Country getById(int id) throws SQLException {

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
    public void updateById(Country country) {

        String sqlUpdate = "UPDATE countryName ";

    }

    @Override
    public void updateByName(Country country) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
