package com.geekbrains.storage.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        new Client().start();
    }

    public void start() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap client = new Bootstrap();
            client.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ByteArrayEncoder(), new StringDecoder(), new ClientDecoder());
                        }
                    });

            ChannelFuture channelFuture = client.connect("localhost", 9000);

            System.out.println("Client has started...");
            while (true) {
                //String msg = String.format("Hello from client %s: %s", Thread.currentThread().getName(), LocalDateTime.now());
                try (FileInputStream fileInputStream = new FileInputStream("text.txt")) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    if (bufferedInputStream.available() > 1024) {
                        byte[] fileBytes = new byte[1024];
                        bufferedInputStream.read(fileBytes);
                        channelFuture.channel().writeAndFlush(fileBytes).sync();
                    } else {
                        byte[] fileBytes = new byte[fileInputStream.available()];
                        bufferedInputStream.read(fileBytes);
                        channelFuture.channel().writeAndFlush(fileBytes).sync();
                    }
                } catch (IOException e) { }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}
