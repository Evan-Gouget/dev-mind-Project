package com.emse.spring.faircorp;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.models.Heater;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
@DataJpaTest
public class HeaterDaoTest {
    @Autowired
    HeaterDao dao;

    @Test
    void shouldFindByRoomId(){
        List<Heater> heater = dao.findByRoomId(-10L);
        org.assertj.core.api.Assertions.assertThat(heater)
                .hasSize(2)
                .extracting(Heater::getId, Heater::getName)
                .contains(
                        Tuple.tuple(-10L, "Heater1")
                )
                .contains(
                        Tuple.tuple(-9L, "Heater2")
                );
    }
    @Test
    void shouldDeleteByRoomId(){
        dao.deleteByRoomId(-10L);
        List<Heater> nullHeater = dao.findByRoomId(-10L);
        org.assertj.core.api.Assertions.assertThat(nullHeater)
                .hasSize(0);
    }
    @Test
    void shouldFindByName(){
        Heater heater = dao.findByName("Heater2");
        org.assertj.core.api.Assertions.assertThat(heater)
                .extracting(Heater::getId, Heater::getName)
                .contains(
                        Tuple.tuple(-9L, "Heater2")
                );
    }

    void shouldFindAll(){
        List<Heater>  heaters = dao.findAll();
        org.assertj.core.api.Assertions.assertThat(heaters)
                .extracting(Heater::getId, Heater::getName)
                .contains(
                        Tuple.tuple(-10L, "Heater1")
                )
                .contains(
                        Tuple.tuple(-9L, "Heater2")
                );
    }

}
