package com.ss.touragency;

import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.Country;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main( String[] args ) throws SQLException {

        CountryDao c = new CountryDao();

        System.out.println(c.getById(1));

    }
}
