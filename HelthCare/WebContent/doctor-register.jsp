<%@page import="com.paf.doctor.model.DoctorDAO"%>
<%@page import="com.paf.doctor.bean.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	if(request.getParameter("nic") != null){
	String nic = request.getParameter("nic");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String contactNumber = request.getParameter("contactNumber");
	String gender = request.getParameter("gender");
	String category = request.getParameter("category");
	String hospitalName = request.getParameter("hospitalName");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	Doctor d = new Doctor(nic,firstName, lastName, contactNumber, gender, category, hospitalName, email, password);
	String status = DoctorDAO.registerDoctor(d);
	
	session.setAttribute("doctor_registration_status", status);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Doctor Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
        <fieldset>
            <h3>
                <span> Doctor Registration</span>
            </h3>

            <form action="doctor-register.jsp">
              
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">NIC</label>
                    <div class="col-sm-10">
                        <input type="text" name="nic" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="firstName" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="lastName" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="contactNumber" class="col-sm-2 col-form-label">Contact Number</label>
                    <div class="col-sm-10">
                        <input type="date" name="contactNumber" class="form-control">
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
                    <label for="category" class="col-sm-2 col-form-label">Category</label>
                    <div class="col-sm-10">
                        <input type="text" name="category"  class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="hospitalName" class="col-sm-2 col-form-label">Hospital Name</label>
                    <div class="col-sm-10">
                        <select id="hospitalName" name ="hospitalName">
  							<option value="Asiri Hospital">Asiri Hospital</option>
  							<option value="Lanka Hospitals">Lanka Hospitals</option>
  							<option value="Ninewells Hospital">Ninewells Hospital</option>
  							<option value="Winlanka Hospital">Winlanka Hospital</option>
						</select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" name="email"  class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                      <button type="submit" class="btn btn-success">Register</button>
                    </div>
                </div>
            </form>  
            
            <div class="alert alert-success">
            	<%
            		if(session.getAttribute("doctor_registration_status") != null) {
            			out.print(session.getAttribute("doctor_registration_status"));
            		}
            	%>
            </div>
            
        </fieldset>
    </div>
</body>
</html>