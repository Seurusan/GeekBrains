package com.seurusan.storage.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        InetSocketAddress address = new InetSocketAddress("localhost", 9297);
        SocketChannel client = SocketChannel.open(address);

        log("Establishing connection on port " + address.getPort() + "...");

        ArrayList<String> dataThrough = new ArrayList<String>();

        dataThrough.add("Check one");
        dataThrough.add("Check two");
        dataThrough.add("Check three");
        dataThrough.add("Check four");
        dataThrough.add("Crunchify");

        for (String text : dataThrough) {
            byte[] message = new String (text).getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            client.write(buffer);

            log("sending: " + text);
            buffer.clear();

            Thread.sleep(2000);
        }
        client.close();
    }

    private static void log(String str) {
        System.out.println(str);
    }
}
