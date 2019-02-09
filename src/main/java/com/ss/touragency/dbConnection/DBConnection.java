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

    public static Connection getDbConnection() throws SQLException {

        if(connection == null){
            connection = initConnection();
        }

        return connection;
    }

    public void closeConnection() throws SQLException {

        if(connection == null){
            return;
        }
        connection.close();
    }

    private static Connection initConnection() throws SQLException {

        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

    }

//    public static Connection getDbConnection() throws SQLException {
//        return DriverManager.getConnection(DbProperties.url, DbProperties.user, DbProperties.password);
//    }

}