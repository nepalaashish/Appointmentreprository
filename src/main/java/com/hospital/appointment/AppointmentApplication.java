package com.hospital.appointment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.hospital.appointment.appointmententity.Users;
import com.hospital.appointment.appointmentreprository.Userreprository;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class AppointmentApplication {
	
	@Autowired
    private Userreprository repository;

    @PostConstruct
    public void initUsers() {
        List<Users> users = Stream.of(
                new Users(101, "user0", "password", "user0@gmail.com"),
                new Users(102, "user1", "pwd1", "user1@gmail.com"),
                new Users(103, "user2", "pwd2", "user2@gmail.com"),
                new Users(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

	public static void main(String[] args) {
		SpringApplication.run(AppointmentApplication.class, args);
		
}
	
	@Bean
	public RestTemplate restTemplate() 
	{
	return new RestTemplate();
   }
}



