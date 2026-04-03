package com.gpsromp.gps.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "gps_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GPSDataEntity {

    @Id
    private String id;

    private String timestamp;

    private double latitud;

    private double longitud;

    private int velocidad;

    private boolean gpsValido;

    private boolean acc;

    private boolean corteMotor;

    @Indexed
    @Field("created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

}
