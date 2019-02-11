package com.ss.touragency.dao;

import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.City;
import com.ss.touragency.entity.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDao implements ICrudDao<Hotel> {
    @Override
    public void insert(Hotel hotel) {
        String insertHotel = "INSERT INTO hotel(hotelName,City_idCity,availableCount) VALUES(?,?,?)";
        Connection connection = DBConnection.getDbConnection();

        if (connection != null) {

            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(insertHotel);

                preparedStatement.setString(1, hotel.getHotelName());
                preparedStatement.setLong(2, hotel.getCity().getCityId());
                preparedStatement.setInt(3, hotel.getAvailableCount());
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<Hotel> selectAll() {
        List<Hotel> hotelList = new ArrayList<>();

        String sql = "SELECT * FROM HOTEL";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = DBConnection.getDbConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setHotelId(resultSet.getLong("idHotel"));
                hotel.setHotelName(resultSet.getString("hotelName"));
                CityDao city = new CityDao();
                hotel.setCity(city.selectById(resultSet.getLong(3)));
                hotel.setAvailableCount(resultSet.getInt("availableCount"));
                hotelList.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotelList;
    }

    @Override
    public Hotel selectById(Long id) {
        String sql = "SELECT * FROM HOTEL WHERE idHotel=" + "'" + id + "'";
        Statement statement = null;
        ResultSet resultSet = null;
        Hotel hotel = null;

        try {
            resultSet = statement.executeQuery(sql);
            statement = DBConnection.getDbConnection().createStatement();

            while (resultSet.next()) {
                hotel = new Hotel();
                hotel.setHotelId(resultSet.getLong("idHotel"));
                hotel.setHotelName(resultSet.getString("hotelName"));
                CityDao city = new CityDao();
                hotel.setCity(city.selectById(resultSet.getLong(3)));
                hotel.setAvailableCount(resultSet.getInt("availableCount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return hotel;
    }

    @Override
    public void updateById(Hotel hotel, Long id) {
        String sqlUpdate = "UPDATE hotel SET hotelName=?,City_idCity=?,availableCount=?" + " WHERE idHotel=" + id + "";
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getDbConnection();
        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(sqlUpdate);

                preparedStatement.setString(1, hotel.getHotelName());
                preparedStatement.setLong(2, hotel.getCity().getCityId());
                preparedStatement.setInt(3, hotel.getAvailableCount());

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
