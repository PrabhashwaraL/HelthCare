package com.paf.patient.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.paf.patient.bean.Patient;

public class PatientDAO {
	
	public static Connection getConnection( ) {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HelthCare_patient", "root", "admin123");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static String registerPatient(Patient patient) {
		
		String output = null;
		
		try {
			Connection con = getConnection();
			
			String query = "insert into patient_registration values(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, patient.getNic());
			ps.setString(2, patient.getFirstName());
			ps.setString(3, patient.getLastName());
			ps.setString(4, patient.getDob());
			ps.setString(5, patient.getGender());
			ps.setString(6, patient.getEmail());
			ps.setString(7, patient.getPassword());
			
			ps.executeUpdate();
			
			output = "Patient Register Successfully";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			output = "Error in registration process";
		}
		
		return output;
		
	}
	
	public static String patientLogin(Patient patient) {
		
		String status = "invalid user";
		
		try {
			Connection con = getConnection();
			
			String query = "select patientPassword from patient_registration where email = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, patient.getEmail());
			
			ResultSet rs = ps.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("ddd");
				 if (patient.getPassword() == rs.getString("patientPassword") ) {
					 status = "valid user";
				 }
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public static String updatePatient(Patient patient) {
		String status = null;
		
		try {
			Connection con = getConnection();
			
			String queary = "update patient_registration set firstName=?, lastName=?, dob=?, gender=?,"
					+ "email=?, patientPassword=? where nic=?";
			
			PreparedStatement ps = con.prepareStatement(queary);
			
			ps.setString(1, patient.getFirstName());
			ps.setString(2, patient.getLastName());
			ps.setString(3, patient.getDob());
			ps.setString(4, patient.getGender());
			ps.setString(5, patient.getEmail());
			ps.setString(6, patient.getPassword());
			ps.setString(7, patient.getNic());
			
			ps.executeUpdate();
			
			status = "Patient Update Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error in update process";
		}
		
		return status;
	}
	
	
	
	

}
