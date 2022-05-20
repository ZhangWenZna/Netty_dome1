package com.zwz.day01.test02;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * 黏包/半包解析训练
 */
public class TestByteBufferExam {
    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,word\nI'm zhangsan\nHo".getBytes(StandardCharsets.UTF_8));
        split(source);
        source.put("w are you\n".getBytes(StandardCharsets.UTF_8));
        split(source);
    }

    public static void split(ByteBuffer source){
        source.flip();
        for (int i=0;i<source.limit();i++){
            if(source.get(i)=='\n'){
                int length=i+1-source.position();
                System.out.println("**************");
                ByteBuffer target = ByteBuffer.allocate(length);
                for(int j=0;j<length;j++){
                    byte b=source.get();
                    target.put(b);
                    target.flip();
                    System.out.print((char) target.get());
                    target.clear();
                }

            }
        }
        source.compact();
    }

}
