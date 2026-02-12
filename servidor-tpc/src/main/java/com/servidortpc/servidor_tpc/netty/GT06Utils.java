package com.servidortpc.servidor_tpc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
public class GT06Utils {

    public static String decodeImei(byte[] bytes){
        StringBuilder imei = new StringBuilder();
        
        for (byte b : bytes) {
            imei.append((b >> 4) & 0x0F);
            imei.append(b & 0x0F);
        }
        return imei.toString();
    }

    // construir ACK LOGIN (Respuesta de confirmacion de login)
    public static ByteBuf buildLoginAck(short serial) {  

        ByteBuf paquete = Unpooled.buffer();

        paquete.writeByte(0x78); // Primer byte
        paquete.writeByte(0x78); // Segundo byte
        paquete.writeByte(0x5); // Longitud del paquete (5 bytes)
        paquete.writeByte(0x1); // Protocolo (ACK de login)
        paquete.writeShort(serial); // Numero de serie (2 bytes)

        // CRC ficticio por ahora 

        paquete.writeByte(0xD9); 
        paquete.writeByte(0xDC);

        paquete.writeByte(0x0D);
        paquete.writeByte(0x0A);

        return paquete;
    }

}
