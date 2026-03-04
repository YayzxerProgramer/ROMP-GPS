package com.servidortpc.servidor_tpc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servidortpc.servidor_tpc.Model.GPSData;
import com.servidortpc.servidor_tpc.Service.GpsDataService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/data/ubicacion")
public class DataController {

    private final GpsDataService gpsDataService; // Es un objeto 
    //de la clase GpsDataService que se usa para manejar la lógica de negocio relacionada con los datos GPS.

    public DataController(GpsDataService gpsDataService) {
        this.gpsDataService = gpsDataService; // Se inyecta el GpsDataService a través del constructor.
    }
    
    @PostMapping
    public ResponseEntity<Void>Receive(@RequestBody GPSData gpsData) {
        gpsDataService.recibirData(gpsData);
        return ResponseEntity.noContent().build();
    }
    

}
