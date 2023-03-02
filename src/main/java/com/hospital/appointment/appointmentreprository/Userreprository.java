package com.hospital.appointment.appointmentreprository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.appointment.appointmententity.Users;

public interface Userreprository extends JpaRepository<Users ,Integer > 
{

	

	

	Users findByusername(String username);

}
