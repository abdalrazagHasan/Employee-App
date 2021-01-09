package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToDatabase {

    private Connection connection;

    public ConnectToDatabase() throws IOException, SQLException {
        connect();
    }

    private void connect() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("connection.txt"));

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url_jdbc = properties.getProperty("url");

        connection = DriverManager.getConnection(url_jdbc,username,password);
        System.out.println("Connection successfully -> "+url_jdbc +"\n");
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
