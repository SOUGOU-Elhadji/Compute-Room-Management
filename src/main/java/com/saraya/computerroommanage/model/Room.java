package com.saraya.computerroommanage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    @Column(length = 200)
	    private String nameRoom;
	    @OneToMany(mappedBy = "room", cascade = CascadeType.MERGE)
	    private List<Machine> machines = new ArrayList<>();

	    public Room() {
	    }

	    public Room(Integer id, String nameRoom) {
	        this.id = id;
	        this.nameRoom = nameRoom;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getNameRoom() {
	        return nameRoom;
	    }

	    public void setNameRoom(String nameRoom) {
	        this.nameRoom = nameRoom;
	    }

	    @Override
	    public String toString() {
	        return nameRoom;
	    }

	    public List<Machine> getMachines() {
	        return machines;
	    }

	    public void setMachines(List<Machine> machines) {
	        this.machines = machines;
	    }
	    
	    
}
