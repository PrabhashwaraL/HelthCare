<%@page import="com.paf.appoinment.model.Appoinments"%>
<jsp:useBean id="appoinment" class="com.paf.appoinment.bean.Appoinments_b"></jsp:useBean>
<jsp:setProperty property="*" name="appoinment"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
		String status = Appoinments.addAppoinment(appoinment);

		session.setAttribute("patient_addAppoinment_status", status);
		
		response.sendRedirect("EnterAppoinments.jsp");
		
	
%>

</body>
</html>