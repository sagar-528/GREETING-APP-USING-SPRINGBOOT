package com.bridgelabz.Services;

import com.bridgelabz.Model.Greeting;
import com.bridgelabz.Model.User;

import java.util.List;
import java.util.Optional;

public interface GreetingService {
    Greeting getFirstGreeting();
    Greeting getMessage();
    Greeting getUserDetail(User user);
    void GreetingInRepo(Greeting greetMessage);
    Optional<Greeting> findGreetingInRepo(long Id);
    List<Greeting> getAllGreetings();
    void updateGreetingRepo(Greeting greetMessage);
    void deleteGreetingFromRepo(long Id);
}
