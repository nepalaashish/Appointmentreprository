package com.hospital.appointment.appointmentservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hospital.appointment.appointmententity.Appoint;
import com.hospital.appointment.appointmentreprository.Appointmentreprository;
import com.hospital.appointment.valueobject.Doctor;
import com.hospital.appointment.valueobject.ResponseTemplateVO;

@Service
public class Appointmerntservice {
	
	 
	@Autowired
	public Appointmentreprository appointmentrepo;

	
	  @Autowired public RestTemplate restTemplate;
	 
	
	  public Appoint getallappoint(int aid)
	  {
			
			return appointmentrepo.findByAid(aid);
		}
	

	public List<Appoint> getallappointment()
	{
		List<Appoint> list = (List<Appoint>) this.appointmentrepo.findAll();
		return list;
	}

	public void updateappointment(int Aid, Appoint appointment) {
		appointmentrepo.save(appointment);

	}

	public void deleteappointments(int Aid) {
		appointmentrepo.deleteById(Aid);

	}

	public Appoint addappointment(Appoint appointment) {
		// TODO Auto-generated method stub
		return appointmentrepo.save(appointment);
	}

	public Appoint save(Appoint appointment) {
		// TODO Auto-generated method stub
		return appointmentrepo.save(appointment);
	}
	
	  public ResponseTemplateVO getappointmentwithdoctor(int did) 
	  { 
	ResponseTemplateVO vo = new ResponseTemplateVO();
	 Appoint appoint = appointmentrepo.findByDid(did);
	 Doctor doctor =restTemplate.getForObject("http://localhost:9001/doctors/"+appoint.getdid() , Doctor.class);
	 vo.setAppoint(appoint); 
	 vo.setDoctor(doctor); 
	 return vo;
	
	  }

	
	}
	  
	 
	


