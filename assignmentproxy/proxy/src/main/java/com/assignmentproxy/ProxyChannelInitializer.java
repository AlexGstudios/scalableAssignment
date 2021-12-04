package com.assignmentproxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ProxyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final Proxy proxy;

    public ProxyChannelInitializer(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        Bootstrap bootstrap = new Bootstrap();
        Channel channel = bootstrap.group(proxy.getEventLoopGroup()).channel(NioSocketChannel.class)
                .handler(new ServerChannelInitializer(socketChannel)).connect("192.168.0.192", roundRobin()).sync()
                .channel();

        socketChannel.pipeline().addFirst(new ProxyChannelHandler(channel));
    }

    private int nodeIndex = 0;

    private int roundRobin() {
        int port = proxy.servers.get(nodeIndex++).getPORT();

        if (nodeIndex >= proxy.servers.size()) {
            nodeIndex = 0;
        }
        return port;
    }

}
