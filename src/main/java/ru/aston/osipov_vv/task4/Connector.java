package ru.aston.osipov_vv.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Connector {
    private static Connection connection;

    public static Connection connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("app");
            String url = resourceBundle.getString("db.url");
            String user = resourceBundle.getString("db.user");
            String password = resourceBundle.getString("db.password");

            connection = DriverManager.getConnection(url, user, password);
            return connection;
        }

        return connection;
    }
}
