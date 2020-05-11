package com.bridgelabz.Repository;

import com.bridgelabz.Model.Greeting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GreetingRepository extends MongoRepository<Greeting, Long> {
}
