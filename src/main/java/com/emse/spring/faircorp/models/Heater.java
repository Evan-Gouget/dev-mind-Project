package com.emse.spring.faircorp.models;

import javax.persistence.*;

@Entity
@Table(name = "RHEATER")
public class Heater {
    @Id
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=true)
    private Long power;

    @ManyToOne
    private Room room;

    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    public Heater() {
    }

    public Heater(String name, HeaterStatus status, Room room) {
        this.heaterStatus = status;
        this.name = name;
        this.room = room;
        this.power = null;
    }

    public Heater(String name, HeaterStatus status, Room room, Long power) {
        this.heaterStatus = status;
        this.name = name;
        this.room = room;
        this.power = power;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getPower() {
        return this.power;
    }

    public void setPower(Long power) {
        this.power = power;
    }
    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
