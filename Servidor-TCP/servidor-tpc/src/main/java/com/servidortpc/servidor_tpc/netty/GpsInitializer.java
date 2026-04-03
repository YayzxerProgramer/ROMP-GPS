package com.servidortpc.servidor_tpc.netty;

import com.servidortpc.servidor_tpc.Service.GpsDataService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

@Component
public class GpsInitializer extends ChannelInitializer<SocketChannel> {

    private final GpsDataService gpsDataService;
    private final RestTemplate restTemplate;

    public GpsInitializer(GpsDataService gpsDataService, RestTemplate restTemplate) {
        this.gpsDataService = gpsDataService;
        this.restTemplate = restTemplate;
    }

    @Override
    protected void initChannel(SocketChannel canal) throws Exception {
        ChannelPipeline flujo = canal.pipeline();
        flujo.addLast(new GpsServerHandler(gpsDataService, restTemplate));
    }

}
