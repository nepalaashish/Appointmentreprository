package Appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospital.appointment.appointmententity.Appoint;
import com.hospital.appointment.appointmentreprository.Appointmentreprository;
import com.hospital.appointment.appointmentservice.Appointmerntservice;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;






@SpringBootTest(classes= {AppointmentTest.class})
public class AppointmentTest {
	@Mock
	Appointmentreprository appointrepro;
	
	@InjectMocks
  Appointmerntservice appointservice;
	
	public List<Appoint> allappoint;
	
	@Test
	@Order(1)
    void test_getallappointment()
   
	{
		
	List<Appoint> allappoint = new ArrayList<Appoint>();	
	allappoint.add(new Appoint("Aashih", "kumar", 1, "Normal", 23, 21, 24, 26 ));
	when(appointrepro.findAll()).thenReturn(allappoint);
	assertEquals(1,appointservice.getallappointment().size());
		 
	}
	@Test
	@Order(2)
	void test_adddappointment() 
	{
		Appoint appoint = new Appoint("Aashih", "kumar", 1, "Normal", 23, 21, 24, 26 );
		when(appointrepro.save(appoint)).thenReturn(appoint);
		appointservice.addappointment(appoint);
		assertEquals(appoint,appointservice.addappointment(appoint));
		
	}
	
	@Test
	@Order(3)
	void test_updatedoctor() 
	{
		Appoint appoint = new Appoint("Aashih", "kumar", 1, "Normal", 23, 21, 24, 26 );
		appoint.setaid(1);
		appointrepro.save(appoint);
		assertEquals(appoint, appoint);
		 
	}
	@Test
    @Order(4)
    public void  test_getallappoint() {
       Appoint appoint=new Appoint("Aashih", "kumar", 1, "Normal", 23, 21, 24, 26 );
        when(appointrepro.findByAid(1)).thenReturn( appoint);
        assertEquals(appoint, appointservice.getallappoint(1));
        
    }
	}
	

