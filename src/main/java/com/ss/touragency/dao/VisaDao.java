package com.ss.touragency.dao;

import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.Hotel;
import com.ss.touragency.entity.Visa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisaDao implements ICrudDao<Visa> {
    @Override
    public void insert(Visa visa) {
        String insertHotel = "INSERT INTO visa(Client_idClient,Country_idCountry) VALUES(?,?)";
        Connection connection = DBConnection.getDbConnection();

        if (connection != null) {

            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(insertHotel);


                preparedStatement.setLong(1, visa.getClient().getIdClient());
                preparedStatement.setLong(2, visa.getCountry().getIdCountry());

                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<Visa> selectAll() {
        List<Visa> visaList = new ArrayList<>();

        String sql = "SELECT * FROM VISA";
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = DBConnection.getDbConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                Visa visa = new Visa();
                ClientDao clientDao = new ClientDao();
                visa.setClient(clientDao.selectById(resultSet.getLong(2)));
                CountryDao countryDao = new CountryDao();
                visa.setCountry(countryDao.selectById(resultSet.getLong(3)));
                visaList.add(visa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return visaList;
    }

    @Override
    public Visa selectById(Long id) {
        Connection connection = DBConnection.getDbConnection();
        String sql = "SELECT * FROM VISA WHERE idVisa=" + "'" + id + "'";
        Statement statement;
        ResultSet resultSet;
        Visa visa = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                visa = new Visa();
                ClientDao clientDao = new ClientDao();
                visa.setClient(clientDao.selectById(resultSet.getLong("Client_idClient")));
                CountryDao countryDao = new CountryDao();
                visa.setCountry(countryDao.selectById(resultSet.getLong("Country_idCountry")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visa;
    }

    @Override
    public void updateById(Visa visa, Long id) {
        String sqlUpdate = "UPDATE VISA SET Client_idClient=?, Country_idCountry=? " + " WHERE idVisa=" + id + "";
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getDbConnection();
        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(sqlUpdate);

                preparedStatement.setLong(1, visa.getClient().getIdClient());
                preparedStatement.setLong(2, visa.getCountry().getIdCountry());
                preparedStatement.setLong(3, visa.getId());

                preparedStatement.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(Long id) {

    }
}
