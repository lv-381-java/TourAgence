package com.ss.touragency.dbConnection;

import com.ss.touragency.util.DbProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mydb"
            + "?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USER = "onlyVone";
    private static final String DB_PASSWORD = "kxfat92a";

    public static Connection getDbConnection() {

        if(connection == null){
            connection = initConnection();
        }

        return connection;
    }

    public void closeConnection() {

        if(connection == null){
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection initConnection() {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

}