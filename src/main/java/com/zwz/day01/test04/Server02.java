package com.zwz.day01.test04;


import lombok.extern.slf4j.Slf4j;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;


/**
 * 非阻塞状态(浪费资源)
 */
@Slf4j
public class Server02 {
    public static void main(String[] args) throws Exception{

        ByteBuffer buffer=ByteBuffer.allocate(16);

        //使用nio来理解阻塞模式

        //创建一个服务器
        ServerSocketChannel scc = ServerSocketChannel.open();
        scc.configureBlocking(false);//非阻塞模式

        //2.绑定监听端口
        scc.bind(new InetSocketAddress(8080));

        //连接集合
        List<SocketChannel> channels=new ArrayList<>();

        //3.accept
        while (true){
            //建立与客户端连接,SocketChannel用来和客户端之间通信
            //log.debug("connecting....");
            SocketChannel sc = scc.accept();//方法默认阻塞状态，线程停止运行
            //log.debug("connectted....{}" ,sc);
            if (sc!=null){
                log.debug("connected...{}",sc);
                sc.configureBlocking(false);//非阻塞模式
                channels.add(sc);
            }

            //5.接收客户端发送的数据
            for (SocketChannel channel : channels) {
                //log.debug("beforev read...{}", channel);
                int read = channel.read(buffer);//非阻塞模式，线程继续运行，没有读到数据返回0
                if (read > 0) {
                    buffer.flip();
                    System.out.println(buffer.get());
                    buffer.clear();
                    log.debug("after read...{}", channel);
                }
            }
        }
    }

}

