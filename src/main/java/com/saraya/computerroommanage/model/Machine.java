package com.saraya.computerroommanage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "machines")
public class Machine {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200)
    private String ipadresse;
    @Column(length = 200)
    private String macadresse;
    @Column(length = 200)
    private String marque;
    @ManyToOne
    private Room room = new Room();
    @ManyToOne
    private User user = new User();


    public Machine() {
    }

    public Machine(Integer id, String ipadresse, String macadresse, String marque, Room room, User user) {
        this.id = id;
        this.ipadresse = ipadresse;
        this.macadresse = macadresse;
        this.marque = marque;
        this.room = room;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpadresse() {
        return ipadresse;
    }

    public void setIpadresse(String ipadresse) {
        this.ipadresse = ipadresse;
    }

    public String getMacadresse() {
        return macadresse;
    }

    public void setMacadresse(String macadresse) {
        this.macadresse = macadresse;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
	public String toString() {
		return marque;
	}
}
