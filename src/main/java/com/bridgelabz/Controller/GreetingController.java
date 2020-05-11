package com.bridgelabz.Controller;

import com.bridgelabz.Model.Greeting;
import com.bridgelabz.Model.User;
import com.bridgelabz.Services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/home")
    public ResponseEntity getMessage(){
        return new ResponseEntity<Greeting>(greetingService.getFirstGreeting(), HttpStatus.OK);
    }

    @GetMapping("/home/message")
    public ResponseEntity<Greeting> sayMessage(){
        return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
    }

    @PostMapping("/home/custom")
    public ResponseEntity<Greeting> customGreeting(@RequestBody User user) {
        return new ResponseEntity<>(greetingService.getUserDetail(user), HttpStatus.OK);
    }

    @PostMapping("/home/saves-greeting")
    public void saveGreeting(@RequestBody Greeting greeting) {
        greetingService.GreetingInRepo(greeting);
    }

    @GetMapping("home/find-greeting/{greetingId}")
    public ResponseEntity<Optional<Greeting>> findGreeting(@PathVariable long greetingId) {
        return new ResponseEntity<>(greetingService.findGreetingInRepo(greetingId), HttpStatus.OK);
    }

    @GetMapping("home/find-greeting/all")
    public ResponseEntity<List<Greeting>> allGreetings() {
        return new ResponseEntity<>(greetingService.getAllGreetings(), HttpStatus.OK);
    }

    @PostMapping("home/update-greeting")
    public void updateGreeting(@RequestBody Greeting greeting) {
        greetingService.updateGreetingRepo(greeting);
    }

    @DeleteMapping("home/delete-greeting/{greetingId}")
    public void deleteGreeting(@PathVariable long greetingId) {
        greetingService.deleteGreetingFromRepo(greetingId);
    }
}
