package com.zwz.day01.test02;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * ByteBuffer与String之间的转换
 */
public class TestByteBufferString {
    public static void main(String[] args) {
        //1.字符串转ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("hello".getBytes(StandardCharsets.UTF_8));

        //2.Charset
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");//自动切换读模式

        //3.wrap
        ByteBuffer buffer2 = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));//自动切换读模式

        //转换string
        String s= StandardCharsets.UTF_8.encode(String.valueOf(buffer1)).toString();


    }

}
