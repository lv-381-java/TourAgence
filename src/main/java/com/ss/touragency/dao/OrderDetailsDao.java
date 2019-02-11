package com.ss.touragency.dao;

import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.OrderDetails;
import com.ss.touragency.entity.Visa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDao implements ICrudDao<OrderDetails> {

    @Override
    public void insert(OrderDetails orderDetails) {
        String insertHotel = "INSERT INTO visa(Client_idClient,Country_idCountry) VALUES(?,?)";
        Connection connection = DBConnection.getDbConnection();

        if (connection != null) {

            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(insertHotel);
                preparedStatement.setLong(1, orderDetails.getClient().getIdClient());
                preparedStatement.setLong(2, orderDetails.getHotel().getHotelId());

                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<OrderDetails> selectAll() {
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String sql = "SELECT * FROM ORDERDETAILS";
        Statement statement;
        ResultSet resultSet;

        try {
            statement = DBConnection.getDbConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails();
                ClientDao clientDao = new ClientDao();
                orderDetails.setClient(clientDao.selectById(resultSet.getLong(2)));
                HotelDao hotelDao = new HotelDao();
                orderDetails.setHotel(hotelDao.selectById(resultSet.getLong(3)));
                orderDetailsList.add(orderDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetailsList;
    }

    @Override
    public OrderDetails selectById(Long id) {
        String sql = "SELECT * FROM ORDERDETAILS WHERE idOder=" + "'" + id + "'";
        Statement statement;
        ResultSet resultSet;
        OrderDetails orderDetails = new OrderDetails();
        try {
            statement = DBConnection.getDbConnection().createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                orderDetails = new OrderDetails();
                ClientDao client = new ClientDao();
                orderDetails.setClient(client.selectById(resultSet.getLong(2)));
                HotelDao hotelDao = new HotelDao();
                orderDetails.setHotel(hotelDao.selectById(resultSet.getLong(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetails;
    }

    @Override
    public void updateById(OrderDetails orderDetails, Long id) {
        String sqlUpdate = "UPDATE ORDERDETAILS SET Client_idClient=?, Hotel_idHotel=? " + " WHERE idOrder=" + id + "";
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getDbConnection();
        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(sqlUpdate);

                preparedStatement.setLong(1, orderDetails.getClient().getIdClient());
                preparedStatement.setLong(2, orderDetails.getHotel().getHotelId());
                preparedStatement.setLong(3, orderDetails.getId());

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
