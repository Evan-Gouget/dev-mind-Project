package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.models.Window;
import java.util.List;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);

}
