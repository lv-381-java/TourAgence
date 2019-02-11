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
    public List<Visa> selectAll() throws SQLException {
        List<Visa> visaList = new ArrayList<>();

        String sql = "SELECT * FROM VISA";
        Statement statement = DBConnection.getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Visa visa = new Visa();
//            CityDao city = new CityDao();
//            hotel.setCity(city.selectById(resultSet.getLong(3)));

            ClientDao client = new ClientDao();
            visa.setClient(client.selectById(resultSet.getLong(2)));
            CountryDao country = new CountryDao();
            visa.setCountry(country.selectById(resultSet.getLong(3)));
            visaList.add(visa);
        }

        return visaList;
    }

    @Override
    public Visa selectById(Long id) throws SQLException {
        String sql = "SELECT * FROM VISA WHERE idVisa=" + "'" + id + "'";
        Statement statement = DBConnection.getDbConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        Visa visa = null;

        while (resultSet.next()) {
            visa = new Visa();
            ClientDao client = new ClientDao();
            visa.setClient(client.selectById(resultSet.getLong(2)));
            CountryDao country = new CountryDao();
            visa.setCountry(country.selectById(resultSet.getLong(3)));
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
