package com.ss.touragency.dao;

import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.Client;
import com.ss.touragency.entity.OrderDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDao implements ICrudDao<OrderDetails>{

    @Override
    public void insert(OrderDetails orderDetails) {

        String insertOrderDetails = "insert into orderdetails(Client_idClient, Hotel_idHotel, beginDate, endDate) values (?,?,?,?)";
        Connection connection = DBConnection.getDbConnection();

        if(connection != null){

            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(insertOrderDetails);
                preparedStatement.setLong(1, orderDetails.getClient().getIdClient());
                preparedStatement.setLong(2, orderDetails.getHotel().getHotelId());
                preparedStatement.setDate(3, orderDetails.getBeginDate());
                preparedStatement.setDate(4, orderDetails.getEndDate());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<OrderDetails> selectAll(){

        List<OrderDetails> orderDetailsList = new ArrayList<>();
        String selectOrderDetails = "select Client_idClient, Hotel_idHotel, beginDate, endDate from orderdetails";
        Connection connection = DBConnection.getDbConnection();

        if(connection != null){

            Statement statement = null;
            ResultSet resultSet = null;
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(selectOrderDetails);

                while(resultSet.next()){
                    ClientDao clientDao = new ClientDao();
                    HotelDao hotelDao = new HotelDao();
                    OrderDetails orderDetails = new OrderDetails();

                    orderDetails.setClient(clientDao.selectById(resultSet.getLong("Client_idClient")));
                    orderDetails.setHotel(hotelDao.selectById(resultSet.getLong("Hotel_idHotel")));
                    orderDetails.setBeginDate(resultSet.getDate("beginDate"));
                    orderDetails.setEndDate(resultSet.getDate("endDate"));

                    orderDetailsList.add(orderDetails);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orderDetailsList;
    }

    @Override
    public OrderDetails selectById(Long id){

        List<OrderDetails> orderDetailsList = new ArrayList<>();
        Connection connection = DBConnection.getDbConnection();
        String selectOrderDetailsById = "select Client_idClient, Hotel_idHotel, beginDate, endDate from orderdetails where idOrder=?";
        OrderDetails orderDetails = null;

        if (connection != null){

            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                preparedStatement = connection.prepareStatement(selectOrderDetailsById);
                preparedStatement.setLong(1, id);

                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    ClientDao clientDao = new ClientDao();
                    HotelDao hotelDao = new HotelDao();
                    orderDetails = new OrderDetails();

                    orderDetails.setClient(clientDao.selectById(resultSet.getLong("Client_idClient")));
                    orderDetails.setHotel(hotelDao.selectById(resultSet.getLong("Hotel_idHotel")));
                    orderDetails.setBeginDate(resultSet.getDate("beginDate"));
                    orderDetails.setEndDate(resultSet.getDate("endDate"));

                    orderDetailsList.add(orderDetails);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return orderDetails;
    }

    @Override
    public void updateById(OrderDetails orderDetails, Long id) {

        Connection connection = DBConnection.getDbConnection();
        String updateOrderDetailsById = "update orderdetails set Client_idClient, Hotel_idHotel, beginDate, endDate where idOrder=?";

        if(connection != null) {

            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                preparedStatement = connection.prepareStatement(updateOrderDetailsById);
                preparedStatement.setLong(1, id);

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
