package com.zwz.day02;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

public class HelloClient {
    public static void main(String[] args) throws InterruptedException {
        //启动类
        new Bootstrap()
                //2。添加EventLoop
                .group(new NioEventLoopGroup())
                //3.选择客户端的channel实现
                .channel(NioSocketChannel.class)
                //4.添加处理器
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override//在连接建立后读事件
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new StringEncoder());
                        }
                    })
                .connect(new InetSocketAddress("localhost",8080))
                .sync()
                .channel()
                //向服务器发送数据
                .writeAndFlush("Hello Word!");
    }
}
