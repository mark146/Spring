package org.com.web;

import java.sql.*;
import org.junit.Test;

public class DBConnectionTest {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.1:3306/test?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(con);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
