package com.zwz.day01.test02;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {
    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(10).getClass());
        System.out.println(ByteBuffer.allocateDirect(10).getClass());
        /*
        class java.nio.HeapByteBuffer       -java堆内存----读写效率较低，受到垃圾回收（GC）的影响
        class java.nio.DirectByteBuffer     -直接内存----读写效率较高（少拷贝一次）不会受到GC的影响，因为系统内存所以分配的效率低 可能内存泄露
         */

    }
}
