package com.hospital.appointment.appointmentcontroller;

import java.util.List;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hospital.appointment.JwtUtil.JwtUtil;
import com.hospital.appointment.appointmententity.Appoint;
import com.hospital.appointment.appointmententity.AuthRequest;
import com.hospital.appointment.appointmentservice.Appointmerntservice;
import com.hospital.appointment.valueobject.ResponseTemplateVO;



@RestController
public class Appointcontroller {

	static final String DoctorURL = "http://localhost:9001/doctors";
	static final String DoctorURLDid = "http://localhost:9001/doctors/";

	@Autowired
	private Appointmerntservice appointmentservice;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/")
	public String welcome() {

		return "Welcome you are valid ! Enjoy the RESTAPI ";
	}

	@GetMapping("/getappointment")
	public List<Appoint> getallappointment() {

		return appointmentservice.getallappointment();
	}
	@GetMapping("/getappointment/{aid}")
	public Appoint getallappoint(@PathVariable int aid ) 
	{
	
		 return appointmentservice.getallappoint( aid );
	}

	@PostMapping("/appointment")
	public Appoint adddappointment(@RequestBody Appoint appointment) {
		
		Appoint p = appointmentservice.save(appointment);
		return p;
	}

	@PutMapping("/appointment/{aid}")
	public void updateappointment(@PathVariable("aid") int aid, @RequestBody Appoint appointment) {
		appointmentservice.updateappointment(aid, appointment);
	}

	@DeleteMapping("/appointment/{aid}")
	public void deleteappointments(@PathVariable("aid") int aid) {
		appointmentservice.deleteappointments(aid);
	}

	
	  @GetMapping("/appointmentwithdoctor/{did}") 
	  public ResponseTemplateVO getappointmentwithdoctor(@PathVariable("did") int did) 
	  { 
		  return appointmentservice.getappointmentwithdoctor(did); 
	  }
	
	@GetMapping("/getdoctor")
	public String finddoctors() {
		return restTemplate.exchange(DoctorURL, HttpMethod.GET, null, String.class).getBody();
	}

	@GetMapping("/getdoctor/{did}")
	public String finddoctorsbyDiD(@PathVariable int did) {
		return restTemplate.exchange(DoctorURLDid + did, HttpMethod.GET, null, String.class).getBody();
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
