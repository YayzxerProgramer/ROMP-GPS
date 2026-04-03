package com.servidortpc.servidor_tpc.Service;

import org.springframework.stereotype.Service;

import com.servidortpc.servidor_tpc.Model.GPSData;

@Service
public class GpsDataService {

    private GPSData ultimoDato;

    public void recibirData(GPSData gpsData) {
        this.ultimoDato = gpsData;
    }

    public GPSData obtenerUltimoDato() {
        return ultimoDato;
    }
}
