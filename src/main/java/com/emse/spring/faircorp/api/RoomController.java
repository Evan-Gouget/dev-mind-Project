package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.models.HeaterStatus;
import com.emse.spring.faircorp.models.Room;
import com.emse.spring.faircorp.models.Window;
import com.emse.spring.faircorp.models.WindowStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;

    public RoomController(WindowDao windowDao, RoomDao roomDao) { // (4)
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping(path = "/rooms") // (5)
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }

    @GetMapping(path = "/rooms/{room_id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }

    @PostMapping(path = "/rooms") // (8)
    public WindowDto create(@RequestBody WindowDto dto) {
        // WindowDto must always contain the window room
        Room room = roomDao.getById(dto.getRoomId());
        Window window = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            window = windowDao.save(new Window(dto.getName(), room, dto.getWindowStatus()));
        }
        else {
            window = windowDao.getById(dto.getId());  // (9)
            window.setWindowStatus(dto.getWindowStatus());
        }
        return new WindowDto(window);
    }

    @PutMapping(path = "/rooms/{id}/switch/window")
    public RoomDto switchWindowStatus(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        room.setWindowStatus(room.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        return new RoomDto(room);
    }


    @PutMapping(path = "/rooms/{id}/switch/heater")
    public RoomDto switchHeaterStatus(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        room.setHeaterStatus(room.
                getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        return new RoomDto(room);
    }
}
