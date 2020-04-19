package com.paf.pharmacy.service;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.paf.pharmacy.bean.pharmacy;

import com.paf.pharmacy.model.*;

//import com.google.gson.*;

@Path("/pharmacy")

public class pharmacyServce {

	@POST
	@Path("/medication_information_registration")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String medicationRegister(
			@FormParam("billNo") String billNo,
			@FormParam("doctorName") String doctorName,
			@FormParam("patientName") String patientName,
			@FormParam("date") String date,
			@FormParam("medicationDetails") String md,
			@FormParam("amount") String amount,
			@FormParam("email") String email,
			@FormParam("password") String password) {

		String status = null;

		pharmacy p = new pharmacy(billNo, doctorName, patientName, date, md, amount, email, password);

		status = pharmacyDB.medicationRegister(p);

		return status;
	}

	@POST
	@Path("/pharmacyLogin")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String pharmacyLogin(@FormParam("email") String email, @FormParam("password") String password) {

		String status = "Invalid user";

		pharmacy p = new pharmacy(email, password);

		status = pharmacyDB.pharmacyLogin(p);

		return status;
	}

	@PUT
	@Path("/updatePharmacyDetails")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String updatePharmacyDetails(
			@FormParam("billNo") String billNo,
			@FormParam("doctorName") String doctorName,
			@FormParam("patientName") String patientName,
			@FormParam("medicationDetails") String md,
			@FormParam("date") String date,
			@FormParam("amount") String amount,
			@FormParam("email") String email,
			@FormParam("password") String password) {
		
		pharmacy p = new pharmacy(billNo, doctorName, patientName, date, md, amount, email, password);

		String output = pharmacyDB.updatePharmacyDetails(p);

		return output;
	}

	@GET
	@Path("/medicationList")
	@Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public String getmedicationList() {

		return pharmacyDB.medicationList();

	}

	@DELETE
	@Path("/deletePharmacyDetails")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String deletePharmacyDetails(@FormParam("billNo") String billNo) {

		pharmacy p = new pharmacy();

		p.setNic(billNo);

		String output = pharmacyDB.deletePharmacyDetails(p);

		return output;
	}

}
