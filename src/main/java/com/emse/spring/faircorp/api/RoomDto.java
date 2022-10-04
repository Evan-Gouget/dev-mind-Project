package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.models.*;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

public class RoomDto {
    private Long id;
    private String name;
    private Integer floor;
    private Double currentTemp;
    private Double targetTemp;
    private WindowStatus windowStatus;
    private Set<Window> window;

    private Set<Heater> heater;

    public RoomDto() {
    }
    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.currentTemp = room.getCurrentTemp();
        this.targetTemp = room.getTargetTemp();
        this.window.add(room.getWindows());
        this.heater.add(room.getHeaters()) ;
    }


    public Long getId() {
        return id;
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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public Double getTargetTemp() {
        return targetTemp;
    }

    public void setTargetTemp(Double targetTemp) {
        this.targetTemp = targetTemp;
    }

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    /*
    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

*/

    public Set<Window> getWindow() {
        return window;
    }

    public void setWindow(Set<Window> window) {
        this.window = window;
    }

    public Set<Heater> getHeater() {
        return heater;
    }

    public void setHeater(Set<Heater> heater) {
        this.heater = heater;
    }
}
