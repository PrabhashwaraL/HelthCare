package com.paf.patient.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class Doctor {
	
		public Connection getConnection( ) {

			Connection con = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HelthCare_doctor", "root", "root");
			} catch(Exception e) {
				e.printStackTrace();
			}

			return con;
		}
		
		public void abc() {
			System.out.println();
			//abc
			
		}

	}

