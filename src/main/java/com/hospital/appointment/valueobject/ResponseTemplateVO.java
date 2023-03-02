package com.hospital.appointment.valueobject;

import com.hospital.appointment.appointmententity.Appoint;

public class ResponseTemplateVO {
	private Appoint appoint;
	private Doctor doctor;
	public Appoint getAppoint() 
	{
		return appoint;
	}
	public void setAppoint(Appoint appoint) 
	{
		this.appoint = appoint;
	}
	public Doctor getDoctor()
	{
		return doctor;
	}
	public void setDoctor(Doctor doctor) 
	{
		this.doctor = doctor;
	}
	public ResponseTemplateVO(Appoint appoint, Doctor doctor) {
		super();
		this.appoint = appoint;
		this.doctor = doctor;
	}
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseTemplateVO [appoint=" + appoint + ", doctor=" + doctor + "]";
	}
	

}
