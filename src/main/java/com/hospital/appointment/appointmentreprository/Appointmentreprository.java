package com.hospital.appointment.appointmentreprository;



import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;*/
import org.springframework.stereotype.Repository;

import com.hospital.appointment.appointmententity.Appoint;

@Repository

public interface Appointmentreprository extends JpaRepository<Appoint, Integer> {
	
	/*
	 * @Query(value ="SELECT * FROM appointment WHERE Aid = aid ",nativeQuery =
	 * true)
	 */
	 
	Appoint findByDid(int did);

	Appoint findByAid(int aid);

	

	

}
