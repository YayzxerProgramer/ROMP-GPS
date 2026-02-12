package com.servidortpc.servidor_tpc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class GpsServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext contexto, ByteBuf paquete) throws Exception {

        //Verifica el tamano minimo del paquete
        if (paquete.readableBytes() < 5) {
            return;
        }

        //Esto guarda la posicion en la que lee los bytes
        paquete.markReaderIndex();

        //Tomando bits iniciales (Especificamente el primero y el segundo)
        byte primero = paquete.readByte();
        byte segundo = paquete.readByte();

        //Validando si el primer byte y el segundo es 0x78 y en el caso de que lo sea, eliminar la posicion leida
        if (primero != 0x78 || segundo != 0x78) {
            paquete.resetReaderIndex();
            return;
        }

        //Longitud
        //int longitud = paquete.readUnsignedByte();
        //Protocolo (Aqui identificamos el protocolo en este caso 0x1 que es el estandar de GT06)
        byte protocolo = paquete.readByte();

        //Validacion
        if (protocolo == 0x1) {
            login(contexto, paquete);
        }
    }

    //Login 
    private void login(ChannelHandlerContext contexto, ByteBuf paquete) {
        //Leer IMEI (8 Bytes)
        byte[] imeiBytes = new byte[8];
        paquete.readBytes(imeiBytes);

        String imei = GT06Utils.decodeImei(imeiBytes);
        System.out.println(" GPS conectado IMEI: " + imei);

        // serial number (2 bytes)
        short serial = paquete.readShort();

        //Enviar respuesta de confirmacion 
        ByteBuf respuesta = GT06Utils.buildLoginAck(serial);
        contexto.writeAndFlush(respuesta);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext contexto, Throwable causa) {
        causa.printStackTrace();
        contexto.close();
    }

}
