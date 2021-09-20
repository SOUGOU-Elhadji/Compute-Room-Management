package com.saraya.computerroommanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.computerroommanage.exception.ResourceNotFoundException;
import com.saraya.computerroommanage.model.User;
import com.saraya.computerroommanage.repository.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	
	@GetMapping
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable (value = "id") Integer id) {
		return this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
	}

	@PostMapping("")
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	@PutMapping("/edit/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") Integer id) {
		 User users = this.userRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
		 users.setFirstName(user.getFirstName());
		 users.setLastName(user.getLastName());
		 users.setEmail(user.getEmail());
		 users.setPassword(user.getPassword());
		 users.setState(user.getState());
		 users.setProfil(user.getProfil());
		 users.setMachines(user.getMachines());
		 return this.userRepository.save(users);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") Integer id){
		 User users = this.userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
		 this.userRepository.delete(users);
		 return ResponseEntity.ok().build();
	}
}
