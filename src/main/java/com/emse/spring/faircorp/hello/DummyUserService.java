package com.emse.spring.faircorp.hello;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DummyUserService implements UserService {

    private GreetingService greetingService;

    public DummyUserService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void greetAll() {
        List<String> list = Arrays.asList("Elodie", "Charles");
        for (String name : list) {
            greetingService.greet(name);
        }
    }
}
