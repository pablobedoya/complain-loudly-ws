package com.zetauma.complainloudly.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zetauma.complainloudly.ws.factory.ConnectionFactory;
import com.zetauma.complainloudly.ws.model.Complaint;

public class ComplaintDAO extends ConnectionFactory {
	private static ComplaintDAO instance;

	public static ComplaintDAO getInstance() {
		if (instance == null)
			instance = new ComplaintDAO();
		return instance;
	}
	
	public boolean create(Complaint complaint) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean hasErrors = false;
		
		connection = openConnection();
		
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO complaint (user, image, commentary, latitude, longitude) VALUES(?, ?, ?, ?, ?)");
			
			preparedStatement.setString(1, complaint.getUser());
			preparedStatement.setString(2, complaint.getImage());
			preparedStatement.setString(3, complaint.getCommentary());
			preparedStatement.setFloat(4, (float) complaint.getLatitude());
			preparedStatement.setFloat(5, (float) complaint.getLongitude());
			
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			hasErrors = true;
		} finally {
			closeConnection(connection, preparedStatement);
		}
		
		return hasErrors;
	}

	public List<Complaint> list() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Complaint> complaints = null;

		connection = openConnection();
		complaints = new ArrayList<Complaint>();

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM complaint ORDER BY commentary");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Complaint complaint = new Complaint();
				
				complaint.setUser(resultSet.getString("user"));
				complaint.setImage(resultSet.getString("image"));
				complaint.setCommentary(resultSet.getString("commentary"));
				complaint.setLatitude(resultSet.getFloat("latitude"));
				complaint.setLongitude(resultSet.getFloat("longitude"));

				complaints.add(complaint);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return complaints;
	}
}
