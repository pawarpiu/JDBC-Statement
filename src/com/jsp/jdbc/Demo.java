package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		Connection connection = null;
		String sql = "INSERT INTO student VALUES(8,'xyz','xyz@gmail.com')";

		try {
			// load/register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// establish connection
			connection = DriverManager.getConnection(url, username, password);

			// Create statement
			Statement statement = connection.createStatement();

			// execute statement
			statement.execute(sql);

			// close the statement
			connection.close();
			System.out.println("all good");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
			System.out.println("finally closed");
		}
	}
}
