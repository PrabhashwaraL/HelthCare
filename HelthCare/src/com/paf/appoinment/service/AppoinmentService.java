package com.paf.appoinment.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.paf.appoinment.bean.Appoinments_b;
import com.paf.appoinment.model.Appoinments;
import com.paf.patient.bean.Patient;
import com.paf.patient.model.PatientDAO;



@Path("/appoinment")

public class AppoinmentService {
		
		@POST
		@Path("/patient_appoinment")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String addAppoinments
				(@FormParam("app_no") String app_no,
				@FormParam("nic") String nic,
				@FormParam("firstName") String firstName,
				@FormParam("lastName") String lastName,
				@FormParam("age") String age,
				@FormParam("gender") String gender,
				@FormParam("email") String app_date,
				@FormParam("password") String app_time,
				@FormParam("reason") String reason,
				@FormParam("ref_doc") String ref_doc) {
			
			String status = null;
			
			
			Appoinments_b app = new Appoinments_b(app_no, nic, firstName, lastName, age, gender, app_date, app_time, reason, ref_doc);
			
			status = Appoinments.addAppoinment(app);
			
			return status;
		}
		
		
		@PUT
		@Path("/appoinment_update")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updatePatient(String patientData) {
			JsonObject patient = new JsonParser().parse(patientData).getAsJsonObject();
			
			String nic = patient.get("nic").getAsString();
			String firstName = patient.get("firstName").getAsString();
			String lastName = patient.get("lastName").getAsString();
			String dob = patient.get("dob").getAsString();
			String gender = patient.get("gender").getAsString();
			String email = patient.get("email").getAsString();
			String password = patient.get("password").getAsString();
			
			Patient p = new Patient(nic, firstName, lastName, dob, gender, email, password);
			
			String output = PatientDAO.updatePatient(p);
			
			return output;
		}
	

}
