package com.zwz.day01.test03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try (FileChannel from = new FileInputStream("/Users/macos/gitpackage/Netty_dome1/src/main/java/com/zwz/day01/test03/file/data.txt").getChannel();
             FileChannel to = new  FileOutputStream("/Users/macos/gitpackage/Netty_dome1/src/main/java/com/zwz/day01/test03/file/to.txt").getChannel()
        ) {
            //效率高，底层会利用操作系统的零拷贝进行优化，2g 数据
            from.transferTo(0,from.size(),to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
