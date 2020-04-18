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
		
		Patient p = new Patient(nic, firstName, lastName, dob, gender, email, password);
		
		status = PatientDAO.registerPatient(p);
		
		return status;
	}
	
	@POST
	@Path("/patient_login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String loginPatient(@FormParam("email") String email,
			@FormParam("password") String password) {
		
		String status = "Invalid user";
		
		Patient p = new Patient(email, password);
		
		status = PatientDAO.patientLogin(p);
		
		return status;
	}
	
	@PUT
	@Path("/patient_update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(@FormParam("nic") String nic,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("dob") String dob,
			@FormParam("gender") String gender,
			@FormParam("email") String email,
			@FormParam("password") String password) {
		
		String status = null;
		
		Patient p = new Patient(nic, firstName, lastName, dob, gender, email, password);
		
		String output = PatientDAO.updatePatient(p);
		
		return output;
	}
	
	@GET
	@Path("/patient_list")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatientList() {
		Patient p = new Patient();
		p.setNic("1234");
		
		return p;
	}
	
	@DELETE
	@Path("hospitalName")
	@Consumes(MediaType.APPLICATION_ATOM_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String nic) {
		String status = null;
		
		return null;
	}
	
}
