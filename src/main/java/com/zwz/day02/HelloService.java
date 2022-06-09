package com.zwz.day02;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class HelloService {
    public static void main(String[] args) {
        //1.服务器端启动，负责组装nettty组件，启动服务器
        new ServerBootstrap()
                //2.BoosEventLoop，WorkerEventLoop（selector，thread），group组
                .group(new NioEventLoopGroup())
                //3.选择服务器ServerSocketChannel实现
                .channel(NioServerSocketChannel.class)//OIO,BIO
                //4. boos负责处理连接worker（child）负责处理读写，决定worker（child）执行那些操作
                .childHandler(
                        //5，
                        new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());//解码
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                //打印转换好的字符串
                                System.out.println(msg);
                            }
                        });
                    }
                }).bind(8080);//绑定监听端口
    }
}
