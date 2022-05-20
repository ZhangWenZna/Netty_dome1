package com.zwz.day01.test02;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class TestGatheringWrites {
    public static void main(String[] args) {
        ByteBuffer b1 = StandardCharsets.UTF_8.encode("hello");
        ByteBuffer b2 = StandardCharsets.UTF_8.encode("word");
        ByteBuffer b3 = StandardCharsets.UTF_8.encode("你好");
        try (FileChannel channel = new RandomAccessFile("/Users/macos/Netty/src/main/java/com/zwz/day01/test02/data02.txt", "rw").getChannel()) {
            channel.write(new ByteBuffer[]{b1,b2,b3});
        } catch (IOException e) {
            System.out.println("异常");
        }



    }
}
