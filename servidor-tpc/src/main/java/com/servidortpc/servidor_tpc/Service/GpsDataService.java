package com.servidortpc.servidor_tpc.Service;

import com.servidortpc.servidor_tpc.Infra.SendHTTP;
import com.servidortpc.servidor_tpc.Model.GPSData;

public class GpsDataService {

    private final SendHTTP backendClient; // Es un objeto de la clase
    // SendHTTP que se usa para enviar datos al backend.   
    
    public GpsDataService(SendHTTP backendClient) {
        this.backendClient = backendClient; // Se inyecta el SendHTTP a través del constructor.
    }

    public void recibirData(GPSData gpsData) {
        backendClient.EnviaDatos(gpsData); // Se llama al método EnviaDatos del SendHTTP para enviar los datos al backend.
    }
}
