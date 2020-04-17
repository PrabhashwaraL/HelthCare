package com.paf.appoinment.bean;

public class Appoinments_b {

	private String app_no ;            
	private String nic;
	private String firstName;
	private String lastName;
	private String gender;
	private String age;
	private String app_date;
	private String app_time;
	private String reason;
	private String ref_doc;
	
	public Appoinments_b() {
		
	}
	public Appoinments_b(String app_no,String nic, String firstName, String lastName,String gender, String age, String app_date, String app_time,
			String reason, String ref_doc) {
		
		this.app_no = app_no;
		this.nic = nic;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.app_date = app_date;
		this.app_time= app_time;
		this.reason = reason;
		this.ref_doc = ref_doc;
	}
	
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String dob) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String appDate() {
		return app_date;
	}
	public void appDate(String email) {
		this.app_date= app_date;
	}
	public String getappTime() {
		return app_time;
	}
	public void setappTime(String password) {
		this.app_time = app_time;
	}
	
	
	//jhvuygoiajfoaj
	
}
