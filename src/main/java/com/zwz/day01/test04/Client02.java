package com.zwz.day01.test04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client02 {
    public static void main(String[] args) throws IOException {
        SocketChannel sc=SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8080));
        System.out.println("waiting...");
    }
}
