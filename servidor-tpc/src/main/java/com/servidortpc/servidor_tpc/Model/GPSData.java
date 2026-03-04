package com.servidortpc.servidor_tpc.Model;

public class GPSData {

    private final String imei;
    private final String timestamp;
    private final double latitud;
    private final double longitud;
    private final int velocidad;
    private final boolean gpsValido;
    private final boolean acc;
    private final boolean corteMotor;

    public GPSData(String imei, String timestamp, double latitud, double longitud, int velocidad, boolean gpsValido, boolean acc, boolean corteMotor) {
        this.imei = imei;
        this.timestamp = timestamp;
        this.latitud = latitud;
        this.longitud = longitud;
        this.velocidad = velocidad;
        this.gpsValido = gpsValido;
        this.acc = acc;
        this.corteMotor = corteMotor;
    }

    public String getImei() {
        return imei;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean isGpsValido() {
        return gpsValido;
    }

    public boolean getAcc() {
        return acc;
    }

    public boolean getCorteMotor() {
        return corteMotor;
    }

}
