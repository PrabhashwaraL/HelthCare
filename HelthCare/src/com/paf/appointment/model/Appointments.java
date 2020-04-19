package com.paf.appointment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.paf.appointment.bean.Appointments_b;




public class Appointments {
	
	//connection between MySQL database
	
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




	//Method addAppoinment to call addApppointment service

	public static String addAppoinment(Appointments_b appoinment) {
	
		String output = null;
	
	try {
		Connection con = getConnection();
		
		//sql query to insert data
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
	
	public static String addAppoinment2(Appointments_b appoinment) {
		
		String output = null;
	
	try {
		Connection con = getConnection();
		
		//sql query to insert data
		String query = "insert into patient_appoinment2(app_no,patientNic,app_date,app_time,reason,doctorNic)" + "values(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, appoinment.getAppno());
		ps.setString(2, appoinment.getNic());
		ps.setString(3, appoinment.getappDate());
		ps.setString(4, appoinment.getappTime());
		ps.setString(5, appoinment.getReason());
		ps.setString(6, appoinment.getRefDoc());
		
		
		ps.executeUpdate();
		
		output = "Add Appoinment Successfully";
		
	} catch (Exception e) {
		e.printStackTrace();
		
		output = "Error in adding appoinment process";
	}
	
	return output;
	
	
}
	
	
	//Method updateApoointments to call appointment_update service
	
	
	public static String updateAppoinments(Appointments_b appoinment) {
		String status = null;
		
		try {
			Connection con = getConnection();
			
			//sql query to update database
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
	
	
	
	
	
	public static String deleteAppoinment(Appointments_b appoinment) {
		String status = null;
		
		try {
			Connection con = getConnection();
			
			String query = "delete from patient_appoinment where app_no=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, appoinment.getAppno());
			
			ps.execute();
			
			status = "Appoinment deleted successfuly";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			status = "Error in deleting process.";
		}
		
		return status;
		
	}
	
public static String AppoinmentList() {
		
		String output = "";
		
		try {
			Connection con = getConnection();
			
			output += "<head>\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\r\n" + 
					"integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
					"</head>" + 
					"<body>" +
					"<table border=\"1\"><tr><th>App.No</th>" + "<th>NIC</th><th>First Name</th>" + "<th>Last Name</th>" +
					"<th>Age</th>" + "<th>Gender</th>" + "<th>App.Date</th>" + "<th>App.Time</th>" + "<th>Reason</th>" + "<th>Ref.Doc</th>" +
					"</body>";
			
			String query = "select * from patient_appoinment";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				String app_no = rs.getString("app_no");
				String nic = rs.getString("nic");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String age = rs.getString("age");
				String gender = rs.getString("gender");
				String app_date = rs.getString("app_date");
				String app_time = rs.getString("app_time");
				String reason = rs.getString("reason");
				String ref_doc = rs.getString("ref_doc");
				
				output +="<tr><td>" + app_no + "</td>";
				output += "<td>" + nic + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + age + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + app_date + "</td>";
				output += "<td>" + app_time + "</td>";
				output += "<td>" + reason + "</td>";
				output += "<td>" + ref_doc + "</td>";
				
				
				output += "</tr>";
						
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		output += "</table></body>";
		
		return output;
	}

}
