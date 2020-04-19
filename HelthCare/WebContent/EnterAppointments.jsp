<%@page import="com.paf.appointment.model.Appointments"%>
<%@page import="com.paf.appointment.bean.Appointments_b"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	if(request.getParameter("app_no") != null ) {
        		String apno = request.getParameter("app_no");
        		String nic = request.getParameter("nic") ; 
        		String firstname = request.getParameter("firstName") ; 
        		String lastname = request.getParameter("lastName") ; 
        		String age = request.getParameter("age") ; 
        		String gender = request.getParameter("gender") ; 
        		String appDate = request.getParameter("app_date") ; 
        		String appTime = request.getParameter("app_time") ; 
        		String reason = request.getParameter("reason") ; 
        		String ref_doc = request.getParameter("ref_doc") ;
        		
        		Appointments_b ap = new Appointments_b(apno,nic,firstname,lastname,age,gender,appDate, appTime,reason,ref_doc);
        		
        		Appointments.addAppoinment(ap);
        	
        	
        	}
    %>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Appoinment</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
        <fieldset>
            <h3>
                <span>Appoinments</span>
            </h3>

            <form action="EnterAppoinments.jsp">
            <div class="form-group row">
                    <label for="app_no" class="col-sm-2 col-form-label">App.No</label>
                    <div class="col-sm-10">
                        <input type="text" name="app_no" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">NIC</label>
                    <div class="col-sm-10">
                        <input type="text" name="nic" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">First Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="firstName" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="lastName" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">Age</label>
                    <div class="col-sm-10">
                        <input type="text" name="age" class="form-control">
                    </div>
                </div>
                <fieldset class="form-group">
                    <div class="row">
                      <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
                      <div class="col-sm-10">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="gender" value="male" checked>
                          <label class="form-check-label" for="male">
                            Male
                          </label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="gender" value="female">
                          <label class="form-check-label" for="female">
                            Female
                          </label>
                        </div>
                      </div>
                    </div>
                </fieldset>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">App.Date</label>
                    <div class="col-sm-10">
                        <input type="date" name="app_date"  class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">App.Time</label>
                    <div class="col-sm-10">
                        <input type="text" name="app_time" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">Reason</label>
                    <div class="col-sm-10">
                        <input type="text" name="reason" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">Ref.Doctor</label>
                    <div class="col-sm-10">
                        <input type="text" name="ref_doc" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                      <button type="submit" class="btn btn-success">Add Appoinment</button>
                    </div>
                </div>
            </form>
            <div class="alert alert-success">
            	<%
            		if(session.getAttribute("patient_addAppoinment_status") != null) {
            			out.print(session.getAttribute("patient_addAppoinment_status"));
            		}
            	%>
            </div>  
        </fieldset>
    </div>
    

</body>
</html>

