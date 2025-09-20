package com.ayrton.uberDesafio.repository;

import com.ayrton.uberDesafio.domain.ride.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends MongoRepository<Ride, String> {
}
