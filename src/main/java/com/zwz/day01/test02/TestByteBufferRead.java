package com.zwz.day01.test02;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
@Slf4j
public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();

        //remind从头开始读
        //position=0
        System.out.println("**********remind*********");
        buffer.get();//position=1
        buffer.get();//position=2
        log.debug(String.valueOf((char) buffer.get()));//positipn=3
        buffer.rewind();//position=0
        log.debug(String.valueOf((char) buffer.get()));


        //mark & reset
        //mark 做个标记，记录position的位置，reset 将position位置重置到mark位置
        System.out.println("**********mark & reset*********");
        buffer.rewind();//position=0
        log.debug(String.valueOf((char) buffer.get()));//position=1
        log.debug(String.valueOf((char) buffer.get()));//position=2
        buffer.mark();//加标记，索引为2
        log.debug(String.valueOf((char) buffer.get()));//position=3
        log.debug(String.valueOf((char) buffer.get()));//position=4
        buffer.reset();//position=2
        log.debug(String.valueOf((char) buffer.get()));//position=3
        log.debug(String.valueOf((char) buffer.get()));//position=4

        //get(i) 不会改变索引的位置，直接读取i索引的数据
        System.out.println("**********gey(i)*********");
        buffer.rewind();
        log.debug(String.valueOf((char) buffer.get(3)));//position=0



    }
}
