package com.paf.payment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.paf.doctor.bean.Doctor;
import com.paf.payment.bean.Payment;

public class PaymentDAO {
	
	public static Connection getConnection( ) {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare_payment", "root", "root");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static String registerPayment(Payment payment) {
		
		String output = null;
		
		try {
			Connection con = getConnection();
			
			String query = "insert into payment_registration values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, payment.getAppoinmentID());
			ps.setString(2, payment.getCardType());
			ps.setString(3, payment.getCardNo());
			ps.setString(4, payment.getSecurityCode());
			ps.setString(5, payment.getNameOnCard());
			ps.setString(6, payment.getExpirationDate());
			ps.setString(7, payment.getEmail());
			ps.setString(8, payment.getPhoneNo());
						
			ps.executeUpdate();
			
			output = "Payment Successful";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			output = "Error in registration process";
		}
		
		return output;
		
	}
	
	public static String updatePayment(Payment payment) {
		String status = null;
		
		try {
			Connection con = getConnection();
			
			String query = "update payment_registration set cardType=?, cardNo=?, securityCode=?"
					+ "nameOnCard=?, expirationDate=?, email=?, phoneNo=? where appoinmentID=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			
			ps.setString(1, payment.getCardType());
			ps.setString(2, payment.getCardNo());
			ps.setString(3, payment.getSecurityCode());
			ps.setString(4, payment.getNameOnCard());
			ps.setString(5, payment.getExpirationDate());
			ps.setString(6, payment.getEmail());
			ps.setString(7, payment.getPhoneNo());
			ps.setString(8, payment.getAppoinmentID());
			
			ps.executeUpdate();
			
			status = "Payment Update Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error in update process";
		}
		
		return status;
	}
	
	public static String deletePayment(Payment payment) {
		String status = null;
		
		try {
			Connection con = getConnection();
			
			String query = "delete from payment_registration where appoinmentID=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, payment.getAppoinmentID());
			
			ps.execute();
			
			status = "Payment deleted successfuly";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			status = "Error in deleting process.";
		}
		
		return status;
		
	}
	
	public static String paymentList() {
		
		String output = "";
		
		try {
			Connection con = getConnection();
			
			output += "<head>" + 
					"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"" + 
					"integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">" + 
					"</head>" + 
					"<body>" +
					"<table border=\"1\"><tr><th>Appoinment ID</th><th> Card Type</th><th>Card Number</th><th>Security code</th>" +
					"<th>Name on card</th>" + "<th>Expiration date</th>" + "<th>email</th>" + "<th>Phone Number</th></tr>";
			
			String query = "select * from payment_registration";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				String appoinmentID = rs.getString("appoinmentID");
				String cardType = rs.getString("cardType");
				String cardNo = rs.getString("cardNo");
				String securityCode = rs.getString("securityCode");
				String nameOnCard = rs.getString("nameOnCard");
				String expirationDate = rs.getString("expirationDate");
				String email = rs.getString("email");
				String phoneNo = rs.getString("phoneNo");
				
				output += "<tr><td>" + appoinmentID + "</td>";
				output += "<td>" + cardType + "</td>";
				output += "<td>" + cardNo + "</td>";
				output += "<td>" + securityCode + "</td>";
				output += "<td>" + nameOnCard + "</td>";
				output += "<td>" + expirationDate + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + phoneNo + "</td>";
				
				output += "</tr></table></body>";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return output;
	}

}
