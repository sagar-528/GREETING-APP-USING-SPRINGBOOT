package com.bridgelabz.Services;

import com.bridgelabz.Model.Greeting;
import com.bridgelabz.Model.User;
import com.bridgelabz.Repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Autowired
    Greeting greeting;

    @Autowired
    GreetingRepository greetingRepository;

    @Override
    public Greeting getFirstGreeting() {
       greeting.setMessage("Greeting App");
       greeting.setId(greetingRepository.count() + 1);
       greetingRepository.save(greeting);
        return greeting;
    }

    @Override
    public Greeting getMessage() {
        greeting.setMessage("Hello World!!");
        greeting.setId(greetingRepository.count() + 1);
        greetingRepository.save(greeting);
        return greeting;
    }

    @Override
    public Greeting getUserDetail(User user) {
            if (user.getFirstName() != null && user.getLastName() != null) {
                greeting.setMessage("Hello, " + user.getFirstName() +
                        " " + user.getLastName() + "!");
            } else if (user.getFirstName() != null) {
                greeting.setMessage("Hello, " + user.getFirstName() + "!");
            } else if (user.getLastName() != null) {
                greeting.setMessage("Hello, " + user.getLastName() + "!");
            } else {
                return getMessage();
            }
            greeting.setId(greetingRepository.count() + 1);
            greetingRepository.save(greeting);
            return greeting;
    }

    @Override
    public void GreetingInRepo(Greeting greetMessage) {
        greeting.setId(greetingRepository.count() + 1);
        greetingRepository.save(greeting);
    }

    @Override
    public Optional<Greeting> findGreetingInRepo(long Id) {
        return greetingRepository.findById(Id);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public void updateGreetingRepo(Greeting greetMessage) {
        greetingRepository.save(greetMessage);
    }

    @Override
    public void deleteGreetingFromRepo(long Id) {
        greetingRepository.deleteById(Id);
    }

}
