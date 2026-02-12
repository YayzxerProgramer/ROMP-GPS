package com.servidortpc.servidor_tpc.netty;

import org.springframework.stereotype.Component;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@Component
@ChannelHandler.Sharable
public class GpsHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext contexto) {
        System.out.println("GPS Conectado: " + contexto.channel().remoteAddress());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext contexto, ByteBuf mensaje) throws Exception {
        while (mensaje.isReadable()) {
            System.out.printf("%02X ", mensaje.readByte());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext contexto) {
        System.out.println("GPS desconectado");
    }

}
