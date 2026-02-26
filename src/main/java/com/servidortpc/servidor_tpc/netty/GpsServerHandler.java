package com.servidortpc.servidor_tpc.netty;

import org.springframework.stereotype.Component;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@Component
@ChannelHandler.Sharable
public class GpsServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext contexto) {
        System.out.println("GPS Conectado: " + contexto.channel().remoteAddress());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext contexto, ByteBuf paquete) throws Exception {
        while (paquete.readableBytes() >= 5) {
            // Esto guarda la posicion en la que lee los bytes
            paquete.markReaderIndex();

            // Tomando bits iniciales (Especificamente el primero y el segundo)
            byte primero = paquete.readByte();
            byte segundo = paquete.readByte();

            // Validando si el primer byte y el segundo es 0x78 y en el caso de que lo sea,
            // eliminar la posicion leida
            if (primero != 0x78 || segundo != 0x78) {
                continue;
            }

            // Longitud
            int longitud = paquete.readUnsignedByte();

            // Esperar hasta que el paquete completo llegue
            if (paquete.readableBytes() < longitud + 2) {
                paquete.resetReaderIndex();
                return;
            }

            // Protocolo (Aqui identificamos el protocolo en este caso 0x1 que es el estandar de GT06)
            byte protocolo = paquete.readByte();
            ByteBuf datosPaquete = paquete.readSlice(longitud - 1); // longitud - protocolo
            paquete.skipBytes(2);
            // Validacion
            switch (protocolo) {
                case 0x01 ->
                    login(contexto, paquete);
                case 0x12 ->
                    ubicacion(datosPaquete);
            }
        }

    }

    // Login
    private void login(ChannelHandlerContext contexto, ByteBuf paquete) {

        // Leer IMEI (8 bytes)
        byte[] imeiBytes = new byte[8];
        paquete.readBytes(imeiBytes);

        //Decodificando el IMEI 
        String imei = GT06Utils.decodificarIMEI(imeiBytes);
        // Ahora SÍ leer serial
        short serial = paquete.readShort();

        //Verificando el serial
        System.out.println("Serial recibido: " + String.format("%04X", serial));

        //Imprimiendo el IMEI
        System.out.println("IMEI: " + imei);

        //Construyendo Respuesta (ACK)
        ByteBuf respuesta_ack = GT06Utils.ACK(serial);

        //Guardando el ACK
        byte[] bytes = new byte[respuesta_ack.readableBytes()];
        respuesta_ack.getBytes(0, bytes);

        //Mostrando el ACK
        System.out.print("ACK enviado: ");
        for (byte b : bytes) {
            System.out.printf("%02X ", b);
        }
        System.out.println();

        //Dandole Contexto al Servidor de la respuesta
        contexto.writeAndFlush(respuesta_ack);
    }

    private void ubicacion(ByteBuf paquete) {
        int year = 2000 + paquete.readUnsignedByte();
        int mes = paquete.readUnsignedByte();
        int dia = paquete.readUnsignedByte();
        int hora = paquete.readUnsignedByte();
        int minuto = paquete.readUnsignedByte();
        int segundo = paquete.readUnsignedByte();

        int latitudCruda = paquete.readInt();
        int longitudCruda = paquete.readInt();

        double latitud = latitudCruda / 1_000_000.0;
        double longitud = longitudCruda / 1_000_000.0;

        int velocidad = paquete.readUnsignedByte();

        int estadoMotor = paquete.readUnsignedShort();

        boolean accON = (estadoMotor & 0x2000) != 0;
        boolean corteMotor = (estadoMotor & 0x1000) != 0;
        boolean isValido = (estadoMotor & 0x0400) != 0;

        System.out.printf(
                "Fecha: %04d-%02d-%02d %02d:%02d:%02d, Lat: %f, Lon: %f, Velocidad: %d km/h, ACC: %b, Corte: %b, GPS valido: %b\n",
                year, mes, dia, hora, minuto, segundo, latitud, longitud, velocidad, accON, corteMotor, isValido
        );
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("GPS desconectado");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext contexto, Throwable causa) {
        System.out.println("El error del servidor es: " + causa);
        contexto.close();
    }

}
