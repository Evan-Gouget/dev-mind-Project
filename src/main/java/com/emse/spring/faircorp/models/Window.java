package com.emse.spring.faircorp.models;

import javax.persistence.*;

@Entity
@Table(name = "RWINDOW")
public class Window {
    @Id
    private Long id;

    @Column(nullable=false)
    private String name;

    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;

    @ManyToOne
    private Room room;

    public Window() {
    }

    public Window(String name, Room room, WindowStatus status) {
        this.windowStatus = status;
        this.room = room;
        this.name = name;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }
}
