package com.paf.patient.service;

import com.paf.patient.bean.Patient;
import com.paf.patient.model.PatientDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;

@Path("/patient")
public class PatientService {
	
	@POST
	@Path("/patient_registration")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerPatient(@FormParam("nic") String nic,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("dob") String dob,
			@FormParam("gender") String gender,
			@FormParam("email") String email,
			@FormParam("password") String password) {
		
		String status = null;
		String oshadee;
		
		Patient p = new Patient(nic, firstName, lastName, dob, gender, email, password);
		
		status = PatientDAO.registerPatient(p);
		
		return status;
	}
	
	@PUT
	@Path("patient_update")
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
