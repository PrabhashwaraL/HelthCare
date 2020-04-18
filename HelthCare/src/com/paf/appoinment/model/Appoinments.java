package com.paf.appoinment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.paf.appoinment.bean.Appoinments_b;



public class Appoinments {
	
public static Connection getConnection( ) {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HealthCare_Appoinment", "root", "root123");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

	public static String addAppoinment(Appoinments_b appoinment) {
	
		String output = null;
	
	try {
		Connection con = getConnection();
		
		String query = "insert into patient_appoinment(app_no,nic,firstName,lastName,age,gender,app_date,app_time,reason,ref_doc)" + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, appoinment.getAppno());
		ps.setString(2, appoinment.getNic());
		ps.setString(3, appoinment.getFirstName());
		ps.setString(4, appoinment.getLastName());
		ps.setString(5, appoinment.getAge());
		ps.setString(6, appoinment.getGender());
		ps.setString(7, appoinment.getappDate());
		ps.setString(8, appoinment.getappTime());
		ps.setString(9, appoinment.getReason());
		ps.setString(10,appoinment.getRefDoc());
		
		
		ps.executeUpdate();
		
		output = "Add Appoinment Successfully";
		
	} catch (Exception e) {
		e.printStackTrace();
		
		output = "Error in adding appoinment process";
	}
	
	return output;
	
}
	public static String updateAppoinments(Appoinments_b appoinment) {
		String status = null;
		
		try {
			Connection con = getConnection();
			
			String queary = "update patient_appoinment set nic=?, firstName=?, lastName=?, age=?, gender=?, app_date=?, app_time=?, reason=?, ref_doc=? where app_no=?";
			
			PreparedStatement ps = con.prepareStatement(queary);
			
			ps.setString(1, appoinment.getNic());
			ps.setString(2, appoinment.getFirstName());
			ps.setString(3, appoinment.getLastName());
			ps.setString(4, appoinment.getAge());
			ps.setString(5, appoinment.getGender());
			ps.setString(6, appoinment.getappDate());
			ps.setString(7, appoinment.getappTime());
			ps.setString(8, appoinment.getReason());
			ps.setString(9, appoinment.getRefDoc());
			ps.setString(10, appoinment.getAppno());
			

			ps.executeUpdate();
			
			status = "Appoinment Update Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		status = "Error in update process";
		}		
		return status;
	
	
	}	

}
