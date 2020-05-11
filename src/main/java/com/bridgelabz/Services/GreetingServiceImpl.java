package com.bridgelabz.Services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{
    @Override
    public String firstGreeting() {
        return "My first Greeting";
    }

    @Override
    public String sayMessage() {
        return "Hello World";
    }


}
