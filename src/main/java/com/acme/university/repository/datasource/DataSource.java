package com.acme.university.repository.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.exit;

public class DataSource {
    private static final String DB_CONNECTION_URL_FILE_MODE = "jdbc:h2:~/.h2/sample";
    private static final String DB_CONNECTION_URL_MEMORY_MODE = "jdbc:h2:mem:sample";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    private static Connection connection;


    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            initializeConnection();
        }
        return connection;
    }

    private static void initializeConnection() {
        try {
            connection = DriverManager.getConnection(DB_CONNECTION_URL_MEMORY_MODE, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error while retrieving database connection: " + ex);
            exit(-1);
        }
    }

    public static void loadDatabaseDriver() {
        org.h2.Driver.load();

        // Traditional way of loading database driver
        // H2 driver from http://www.h2database.com
		/*
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
        System.out.println("H2 JDBC driver server has been successfully loaded.");
    }
}
