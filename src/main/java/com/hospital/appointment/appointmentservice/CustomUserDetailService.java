package com.hospital.appointment.appointmentservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospital.appointment.appointmententity.Users;
import com.hospital.appointment.appointmentreprository.Userreprository;

@Service
public class CustomUserDetailService  implements UserDetailsService{
	
	@Autowired 
	private Userreprository userrepo; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	Users user	=userrepo.findByusername(username);
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}
}
