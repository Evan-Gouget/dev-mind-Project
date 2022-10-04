package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.models.Room;
import com.emse.spring.faircorp.models.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {
    List<Window> findById(String Id); // (1).

    @Query("select c from Room c where c.name=:name")  // (2)
    Window findByName(@Param("name") String name);
}