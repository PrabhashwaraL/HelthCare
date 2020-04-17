package com.paf.appoinment.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
				@FormParam("email") String app_date,
				@FormParam("password") String app_time,
				@FormParam("reason") String reason,
				@FormParam("ref_doc") String ref_doc) {
			
			String status = null;
			
			
			Appoinments_b app = new Appoinments_b(app_no, nic, firstName, lastName, age, gender, app_date, app_time, reason, ref_doc);
			
			status = Appoinments.addAppoinment(app);
			
			return status;
		}
	

}
