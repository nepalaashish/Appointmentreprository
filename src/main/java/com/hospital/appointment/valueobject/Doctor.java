package com.hospital.appointment.valueobject;

public class Doctor {
	
	private int did;
	
	private String DoctorFirstName;
	
	private String DoctorLastName;
	
	private String Specialization;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDoctorFirstName() {
		return DoctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		DoctorFirstName = doctorFirstName;
	}

	public String getDoctorLastName() {
		return DoctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		DoctorLastName = doctorLastName;
	}

	public String getSpecialization() {
		return Specialization;
	}

	

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public Doctor(int did, String doctorFirstName, String doctorLastName, String specialization) {
		super();
		this.did = did;
		DoctorFirstName = doctorFirstName;
		DoctorLastName = doctorLastName;
		Specialization = specialization;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
