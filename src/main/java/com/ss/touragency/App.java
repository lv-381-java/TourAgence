package com.ss.touragency;

import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.Country;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main( String[] args ) throws SQLException {

        CountryDao c = new CountryDao();
        Country country = new Country("Ukraine2");

//        System.out.println(c.getById(5));
//        c.deleteById((long) 8);
//        c.updateById(country, (long)6);
//        c.insert(country);
    }
}
