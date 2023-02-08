package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		Connection c = null;
		String ex = "update student set email='' where id= ";

		try {
			// register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// establish connection
			c = DriverManager.getConnection(url, username, password);

			// create statement
			Statement s = c.createStatement();

			// execute statement
			int x = s.executeUpdate(ex);
			if (x > 0)
				System.out.println("executed successfully");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.close();
			System.out.println("finally closed");
		}
	}
}
