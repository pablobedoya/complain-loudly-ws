package com.zetauma.complainloudly.ws.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String SERVER = "localhost";
	private static final String DATABASE = "complainloudly";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://" + SERVER + "/" + DATABASE;
	private static final String USER = "root";
	private static final String PASSWORD = "molotov";

	public Connection openConnection() {
		Connection connection = null;
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void closeConnection(Connection connection, PreparedStatement preparedStatement) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
