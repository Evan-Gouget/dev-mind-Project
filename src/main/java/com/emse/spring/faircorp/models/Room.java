package com.emse.spring.faircorp.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@Entity
public class Room {
    @Id
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Integer floor;

    @Column
    private Double currentTemp;

    @Column
    private Double targetTemp;

    @Enumerated
    private WindowStatus windowStatus;

    @Enumerated
    private HeaterStatus heaterStatus;

    @OneToMany(mappedBy = "room")
    private Set<Window> window;


    @OneToMany(mappedBy = "room")
    public Set<Heater> heater;

    public Room() {
    }

    public Room(String name, Integer floor, Double currentTemp, Double targetTemp, Window window, Heater heater) {
        this.name = name;
        this.floor = floor;
        this.currentTemp = currentTemp;
        this.targetTemp = targetTemp;
        this.window.add(window);
        this.heater.add(heater) ;
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

    public void setFloor(Double targetTemp) {
        this.targetTemp = targetTemp;
    }

    public void setWindows(Window window) {
        this.window.add(window);
    }
    public Window getWindows() {
        return (Window) window;
    }

    public Heater getHeaters() { return (Heater) heater;}

    public void setHeaters(Heater heater) {this.heater.add(heater);    }

    public void setTargetTemp(Double targetTemp) {
        this.targetTemp = targetTemp;
    }

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

}



