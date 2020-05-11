package com.bridgelabz.Controller;

import com.bridgelabz.Services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping
    public ResponseEntity getMessage(){
        return new ResponseEntity(greetingService.firstGreeting(), HttpStatus.OK);
    }
}
