package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	private static Connection con;
	public static Connection getCon()
	{
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root",null);
		} catch (Exception e) {
				
			e.printStackTrace();
		}
			
		return con;
	}

		}

