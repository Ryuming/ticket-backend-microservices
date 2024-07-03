package com.ticket.event.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ticket.event.entities.City;

@Repository
public interface CityRepository extends MongoRepository<City, String> {
    List<City> findByCityNameLike(String cityName);
}
