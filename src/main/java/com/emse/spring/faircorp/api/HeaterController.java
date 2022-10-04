package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.api.WindowDto;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.models.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/heater") // (2)
@Transactional // (3)
public class HeaterController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final HeaterDao heaterDao;


    public HeaterController(WindowDao windowDao, RoomDao roomDao, HeaterDao heaterDao) { // (4)
        this.windowDao = windowDao;
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
    }

    @GetMapping // (5)
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());  // (6)
    }

    @GetMapping(path = "/heaters/{heater_id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null); // (7)
    }

    @PutMapping(path = "/heaters/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
        return new HeaterDto(heater);
    }

    @PostMapping(path = "/heaters") // (8)
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // WindowDto must always contain the window room
        Room room = roomDao.getById(dto.getRoomId());
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(dto.getName(), dto.getHeaterStatus(), room));
        } else {
            heater = heaterDao.getById(dto.getId());  // (9)
            heater.setHeaterStatus(dto.getHeaterStatus());
        }
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/heaters/{heater_id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}