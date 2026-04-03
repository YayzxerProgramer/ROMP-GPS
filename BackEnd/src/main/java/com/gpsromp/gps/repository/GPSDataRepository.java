package com.gpsromp.gps.repository;

import com.gpsromp.gps.model.GPSDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GPSDataRepository extends MongoRepository<GPSDataEntity, String> {

    // Última posición (único GPS)
    Optional<GPSDataEntity> findFirstByOrderByTimestampDesc();

}
