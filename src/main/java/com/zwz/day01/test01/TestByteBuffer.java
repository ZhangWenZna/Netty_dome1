package com.zwz.day01.test01;

import lombok.extern.slf4j.Slf4j;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        //FileChannel
        //1.通过输入输出流     2.RandomAccessFile
        try (FileChannel fileChannel=new FileInputStream("/Users/macos/Netty/src/main/java/com/zwz/day01/data.txt").getChannel();){
            //准备缓冲区a
            ByteBuffer buffer=ByteBuffer.allocate(10);
            //从Channel读取数据  向buffer写入
            while (true) {
                int len=fileChannel.read(buffer);
                buffer.flip();
                log.debug("读取到的字节数{}",len);
                if (len==-1) break;
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    log.debug("实际字节{}",(char)b);
                    //System.out.print((char) b);
                }
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
