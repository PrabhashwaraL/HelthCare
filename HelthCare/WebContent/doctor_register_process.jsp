<%@page import="com.paf.doctor.model.DoctorDAO"%>
<jsp:useBean id="doctor" class="com.paf.doctor.bean.Doctor"></jsp:useBean>
<jsp:setProperty property="*" name="doctor"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String status = DoctorDAO.registerDoctor(doctor);

	session.setAttribute("doctor_registration_status", status);
	
	response.sendRedirect("doctor-register.jsp");
%>

</body>
</html>