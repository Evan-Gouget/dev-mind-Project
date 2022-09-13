package com.emse.spring.faircorp.hello;

import org.springframework.stereotype.Service;

@Service
public class ConsoleGreetingService implements GreetingService{

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}