package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.models.Heater;
import com.emse.spring.faircorp.models.Room;
import com.emse.spring.faircorp.models.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeaterDao extends JpaRepository<Heater, Long>, HeaterDaoCustom {
    List<Window> findById(String Id); // (1).

    @Query("select c from Heater c where c.name=:name")  // (2)
    Heater findByName(@Param("name") String name);

    @Modifying // (3)
    @Query("delete from Heater c where c.room =:room")
    void deleteByRoom(Room room);
}
