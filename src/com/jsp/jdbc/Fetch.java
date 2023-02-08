package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		Connection c = null;
		String sql = "select * from student";
		try {

			// register driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// establish connection
			c = DriverManager.getConnection(url, username, password);

			// create statement
			Statement s = c.createStatement();

			// execute statement
			ResultSet r = s.executeQuery(sql);
			while (r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getString(3));
				System.out.println("=================================");
				System.out.println();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// connection close
			c.close();
			System.out.println("finally executed");
		}
	}
}
