package com.paf.appoinment.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Appoinments {
	
public static Connection getConnection( ) {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HealthCare_Appoinment", "root", "root123");
			System.out.println("Successfully Connected!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	

}
