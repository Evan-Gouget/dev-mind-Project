package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.models.Heater;
import com.emse.spring.faircorp.models.HeaterStatus;
import com.emse.spring.faircorp.models.Room;
import com.emse.spring.faircorp.models.WindowStatus;

import javax.persistence.*;

public class HeaterDto {
    private Long id;
    private String name;
    private HeaterStatus heaterStatus;
    private Room room;
    private Long roomId;
    private String roomName;

    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.heaterStatus = heater.getHeaterStatus();
        this.room = heater.getRoom();
        this.name = heater.getName();
        this.roomName = heater.getRoom().getName();
        this.roomId = heater.getRoom().getId();
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

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}

