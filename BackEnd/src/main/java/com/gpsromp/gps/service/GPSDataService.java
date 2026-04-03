package com.gpsromp.gps.service;

import com.gpsromp.Model.GPSData;
import com.gpsromp.gps.model.GPSDataEntity;
import com.gpsromp.gps.repository.GPSDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GPSDataService {

    private final GPSDataRepository repository;

    /**
     * Guarda un nuevo registro GPS en MongoDB
     */
    public GPSDataEntity save(GPSData gpsData) {
        GPSDataEntity entity = GPSDataEntity.builder()
                .timestamp(gpsData.getTimestamp())
                .latitud(gpsData.getLatitud())
                .longitud(gpsData.getLongitud())
                .velocidad(gpsData.getVelocidad())
                .gpsValido(gpsData.isGpsValido())
                .acc(gpsData.isAcc())
                .corteMotor(gpsData.isCorteMotor())
                .build();

        GPSDataEntity saved = repository.save(entity);
        log.debug("GPS data saved");
        return saved;
    }

    /**
     * Obtiene la última posición conocida del GPS
     */
    public Optional<GPSDataEntity> getLastPosition() {
        return repository.findFirstByOrderByTimestampDesc();
    }
}
