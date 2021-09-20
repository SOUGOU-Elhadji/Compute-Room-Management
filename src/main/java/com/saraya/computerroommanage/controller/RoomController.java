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
import com.saraya.computerroommanage.model.Room;
import com.saraya.computerroommanage.repository.RoomRepository;

@RestController
@RequestMapping("room")
public class RoomController {
	@Autowired
	private RoomRepository roomRepository;

	
	@GetMapping
	public List<Room> getAllRooms() {
		return this.roomRepository.findAll();
	}

	@GetMapping("/get/{id}")
	public Room getRoomById(@PathVariable (value = "id") Integer id) {
		return this.roomRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found with id :" + id));
	}

	@PostMapping
	public Room createRoom(@RequestBody Room room) {
		return this.roomRepository.save(room);
	}
	
	@PutMapping("/edit/{id}")
	public Room updateRoom(@RequestBody Room room, @PathVariable ("id") Integer id) {
		 Room rooms = this.roomRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Room not found with id :" + id));
		 rooms.setNameRoom(room.getNameRoom());
		 rooms.setMachines(room.getMachines());
		 
		 return this.roomRepository.save(room);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Room> deleteRoom(@PathVariable ("id") Integer id){
		 Room rooms = this.roomRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Room not found with id :" + id));
		 this.roomRepository.delete(rooms);
		 return ResponseEntity.ok().build();
	}
}
