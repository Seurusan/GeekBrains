package com.seurusan.storage.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {

        //Open selector for different channels
        Selector selector = Selector.open();
        //Selectable channel for stream-oriented listening sockets
        ServerSocketChannel socket = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 9297);
        //Bind socket to the address and start listening for connections
        socket.bind(address);
        //Configure blocking mode
        socket.configureBlocking(false);

        int operations = socket.validOps();
        SelectionKey selectionKey = socket.register(selector,operations,null);

        //Start the server:
        while (true) {
            log("Waiting for new connections...");
            //Select keys which are ready for IO
            selector.select();

            //Token representing the keys registered
            Set<SelectionKey> keysInUse = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keysInUse.iterator();

            while (iterator.hasNext()) {
                SelectionKey myKey = iterator.next();

                //IsAcceptable test for the key's channel to establish the connection
                if (myKey.isAcceptable()) {
                    SocketChannel client = socket.accept();

                    //Unblock channel's mode
                    client.configureBlocking(false);
                    //Operation-set bit for read operations
                    client.register(selector, SelectionKey.OP_READ);
                    log("Connection established: " + client.getLocalAddress() + "\n");
                } //IsReadable test for the key's channel
                else if (myKey.isReadable()) {
                    SocketChannel client = (SocketChannel) myKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);
                    String result = new String(buffer.array()).trim();

                    log("Message received: " + result);

                    if (result.equals("Close connect")) {
                        client.close();
                        log("\nClosing the connection...");
                        log("\nWaiting for new connections...");
                    }
                }
                iterator.remove();
            }
        }
    }

    private static void log(String str) {
        System.out.println(str);
    }
}
