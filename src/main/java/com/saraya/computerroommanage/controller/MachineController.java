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
import com.saraya.computerroommanage.model.Machine;
import com.saraya.computerroommanage.repository.MachineRepository;

@RestController
@RequestMapping("machine")
public class MachineController {
	@Autowired
	private MachineRepository machineRepository;

	
	@GetMapping
	public List<Machine> getAllMachine() {
		return this.machineRepository.findAll();
	}

	@GetMapping("/get/{id}")
	public Machine getMachineById(@PathVariable (value = "id") Integer id) {
		return this.machineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Machine not found with id :" + id));
	}

	@PostMapping
	public Machine createMachine(@RequestBody Machine machine) {
		return this.machineRepository.save(machine);
	}
	
	@PutMapping("/edit/{id}")
	public Machine updateMachine(@RequestBody Machine machine, @PathVariable ("id") Integer id) {
		Machine machines = this.machineRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Machine not found with id :" + id));
		 machines.setIpadresse(machine.getIpadresse());
		 machines.setMacadresse(machine.getMacadresse());
		 machines.setRoom(machine.getRoom());
		 machines.setUser(machine.getUser());
		 
		 return this.machineRepository.save(machines);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Machine> deleteMachine(@PathVariable ("id") Integer id){
		Machine machines = this.machineRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Machine not found with id :" + id));
		 this.machineRepository.delete(machines);
		 return ResponseEntity.ok().build();
	}
}
