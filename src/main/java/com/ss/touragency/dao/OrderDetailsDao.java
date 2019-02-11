package com.ss.touragency.dao;

import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public OrderDetails selectById(Long id) {
        return null;
    }

    @Override
    public void updateById(OrderDetails orderDetails, Long id) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
