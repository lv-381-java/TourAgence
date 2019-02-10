package com.ss.touragency.dao;

import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.Client;

import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClientDao implements ICrudDao<Client>{

    @Override
    public void insert(Client client) {

        Connection connection = DBConnection.getDbConnection();

    }

    @Override
    public List<Client> selectAll() throws SQLException {
        return null;
    }

    @Override
    public Client selectById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void updateById(Client client, Long id) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
