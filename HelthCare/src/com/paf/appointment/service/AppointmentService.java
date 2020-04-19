package com.paf.appointment.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.paf.appointment.bean.Appointments_b;
import com.paf.appointment.model.Appointments;








@Path("/appoinment")

//Inserting appoinments of a Patient
//Addappoinments service
public class AppointmentService {
		
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
			
			
			Appointments_b app = new Appointments_b(app_no, nic, firstName, lastName, age, gender, app_date, app_time, reason, ref_doc);
			
			status = Appointments.addAppoinment(app);
			
			return status;
		}
		
		//Update patients appoinments
		//updateAppointments service
		
		@PUT
		@Path("/appoinment_update")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateAppoinments
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
			
			Appointments_b app = new Appointments_b(app_no, nic, firstName, lastName, age, gender, app_date, app_time, reason, ref_doc);
			
			String output = Appointments.updateAppoinments(app);
			
			return output;
		}
		
		
		//Delete patient appointments
		//deleteAppointment Service
		
		@DELETE
		@Path("/delete_appoinment")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteAppoinment(@FormParam("app_no") String app_no) {
			
			Appointments_b app = new Appointments_b();
			
			app.setAppno(app_no);
			
			String output = Appointments.deleteAppoinment(app);
			
			return output;
		}
		
		
		//Show inserted data in the database
		//getAppointment Service
		@GET
		@Path("/appoinment_list")
		@Produces(MediaType.TEXT_HTML)
		public String getAppoinmentList() {
			
			return Appointments.AppoinmentList();
			
		}

}
