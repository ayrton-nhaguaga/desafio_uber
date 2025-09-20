package com.ayrton.uberDesafio.repository;

import com.ayrton.uberDesafio.domain.driver.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends MongoRepository<Driver, String> {
}
