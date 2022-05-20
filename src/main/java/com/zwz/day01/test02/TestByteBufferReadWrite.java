package com.zwz.day01.test02;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
@Slf4j
public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);//内存分配
        buffer.put((byte) 0x61);//写入一个数据
        buffer.flip();//切换读
        log.debug(String.valueOf(buffer.get()));//读取一个数据
        buffer.clear();//切换写
        buffer.put(new byte[]{0x62,0x63,0x64});//写入3个数据
        buffer.flip();//切换读
        log.debug(String.valueOf((buffer.get())));
        log.debug(String.valueOf((buffer.get())));
        log.debug(String.valueOf((buffer.get())));
        //log.debug(String.valueOf((buffer.get())));

    }
}
