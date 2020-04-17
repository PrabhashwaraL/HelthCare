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
	public Appoinments_b(String app_no,String nic, String firstName, String lastName,String age, String gender, String app_date, String app_time,
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
	
	public String getAppno() {
		return app_no;
	}
	public void setAppno(String app_no) {
		this.app_no = app_no;
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
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getappDate() {
		return app_date;
	}
	public void setappDate(String app_date) {
		this.app_date= app_date;
	}
	public String getappTime() {
		return app_time;
	}
	public void setappTime(String app_time) {
		this.app_time = app_time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRefDoc() {
		return ref_doc;
	}
	public void setRefDoc(String ref_doc) {
		this.ref_doc = ref_doc;
	}

	
}
