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
				@FormParam("app_date") String app_date,
				@FormParam("app_time") String app_time,
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
		public String updateAppoinments(String appData) {
			JsonObject appoinment = new JsonParser().parse(appData).getAsJsonObject();
			
			String app_no =appoinment.get("app_no").getAsString();

			String nic = appoinment.get("nic").getAsString();
			String firstName = appoinment.get("firstName").getAsString();
			String lastName = appoinment.get("lastName").getAsString();
			String age = appoinment.get("age").getAsString();
			String gender = appoinment.get("gender").getAsString();
			String app_date = appoinment.get("app_date").getAsString();
			String app_time = appoinment.get("app_time").getAsString();
			String reason = appoinment.get("reason").getAsString();
			String ref_doc = appoinment.get("ref_doc").getAsString();
			
			Appoinments_b app = new Appoinments_b(app_no, nic, firstName, lastName, age, gender, app_date, app_time, reason, ref_doc);
			
			String output = Appoinments.updateAppoinments(app);
			
			return output;
		}
		
		
	

}
