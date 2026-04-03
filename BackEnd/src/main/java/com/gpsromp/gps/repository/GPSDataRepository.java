package com.gpsromp.gps.repository;

import com.gpsromp.gps.model.GPSDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface GPSDataRepository extends MongoRepository<GPSDataEntity, String> {

    // Última posición por IMEI
    Optional<GPSDataEntity> findFirstByImeiOrderByTimestampDesc(String imei);

    // Verificar si existe un IMEI
    boolean existsByImei(String imei);

}
