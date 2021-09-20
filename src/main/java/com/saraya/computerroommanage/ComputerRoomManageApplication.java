package com.saraya.computerroommanage;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.saraya.computerroommanage.model.Machine;
import com.saraya.computerroommanage.model.User;
import com.saraya.computerroommanage.repository.UserRepository;

@SpringBootApplication
public class ComputerRoomManageApplication {
	
	//private static final Logger log = LoggerFactory.getLogger(ComputerRoomManageApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ComputerRoomManageApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner tester(UserRepository repo) {
		return (args) -> {
			repo.save(new User("firstName", "lastName", "email", "password", 1, "profil", new ArrayList<Machine>()));
			
			User user = (User) repo.findAll();
			
			log.info(user.toString());
			
		};
	}*/

}
