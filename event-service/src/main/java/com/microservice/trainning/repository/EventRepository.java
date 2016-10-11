package com.microservice.trainning.repository;

import com.microservice.trainning.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}
