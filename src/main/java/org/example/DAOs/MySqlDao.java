package org.example.DAOs;
import org.example.Exceptions.DaoException;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySqlDao {
    public Connection getConnection() throws DaoException {
//        String driver = "C:\\mysql-connector-java-5.1.15-bin (1)";
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "retail_store";
        String userName = "root";
        String password = "";
        Connection connection = null;

        //testing the connection using a try catch
        try {
            connection = DriverManager.getConnection(url + dbName, userName, password);

        } catch (SQLException ex) {
            System.out.println("Connection failed " + ex.getMessage());
        }
        return connection;
    }

    public void freeConnection(Connection connection) throws DaoException {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to free connection: " + e.getMessage());
            System.exit(1);
        }

    }

}
