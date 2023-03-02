package com.hospital.appointment.appointmententity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appoint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String DoctorFirstname;
	private String DoctorLastName;
	private int did;
	private String patientCondition;
	private int age;
	private int phonenumber;
	private int pid;

	public int getaid() {
		return aid;
	}

	public void setaid(int aid) {
		this.aid = aid;
	}

	public String getDoctorFirstname() {
		return DoctorFirstname;
	}

	public void setDoctorFirstname(String doctorFirstname) {
		DoctorFirstname = doctorFirstname;
	}

	public String getDoctorLastName() {
		return DoctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		DoctorLastName = doctorLastName;
	}

	public int getdid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Appoint(String DoctorFirstname, String DoctorLastName, int did, String patientCondition, int age, int phonenumber,
			int pid, int aid) {
		super();
		this.DoctorFirstname = DoctorFirstname;
		this.DoctorLastName = DoctorLastName;
		this.did = did;
		this.patientCondition = patientCondition;
		this.age = age;
		this.phonenumber = phonenumber;
		this.pid = pid;
		this.aid = aid;
	}

	public String getPatientCondition() {
		return patientCondition;
	}

	public Appoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Appointment [DoctorFirstname=" + DoctorFirstname + ", DoctorLastName=" + DoctorLastName + ", Did=" + did
				+ ", Condition=" + patientCondition + ", age=" + age + ", phonenumber=" + phonenumber + ", pid=" + pid + "]";
	}

}
