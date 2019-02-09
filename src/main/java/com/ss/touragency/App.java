package com.ss.touragency;

import com.ss.touragency.dao.CountryDao;
import com.ss.touragency.dbConnection.DBConnection;
import com.ss.touragency.entity.Country;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main( String[] args ) throws SQLException {

        CountryDao c = new CountryDao();
        Country country = new Country("CountryName2");

//        System.out.println(c.selectById((long)5));
//        c.deleteById((long) 10);
//        c.updateById(country, (long)10);
//        c.insert(country);
    }
}
