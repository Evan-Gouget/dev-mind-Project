package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.models.Window;
import com.emse.spring.faircorp.models.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;

}

