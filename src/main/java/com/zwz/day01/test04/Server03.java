package com.zwz.day01.test04;


import com.sun.org.apache.bcel.internal.generic.Select;
import lombok.extern.slf4j.Slf4j;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 非阻塞状态(Selector)
 *
 * accept --会在有连接请求时触发
 * connect --是客户端，连接建立后触发
 * read --可读事件
 * write --可写事件
 */
@Slf4j
public class Server03 {
    public static void main(String[] args) throws Exception{
        //2.创建Selector
        Selector selector = Selector.open();//管理多个Channel

        ByteBuffer buffer=ByteBuffer.allocate(16);
        ServerSocketChannel scc = ServerSocketChannel.open();
        scc.configureBlocking(false);

        //2.建立Selector和Channel的联系（注册）
        //SelectionKey是事件发生后通过它得到那个channel发生的事件
        SelectionKey sscKey = scc.register(selector, 0, null);
        //设置key只关注accept事件
        sscKey.interestOps(SelectionKey.OP_ACCEPT);
        log.debug("register key:{}",sscKey);
        scc.bind(new InetSocketAddress(8080));
        while (true){
            //3.select方法,没有事件发生，线程阻塞，有事件时线程才会向下运行
            //select 在事件未处理时，它不会阻塞，事件发生后要么处理，要么取消，不能置之不理
            selector.select();

            //4.处理事件
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();//selectedKeys内部包含了所以发生的事件，set集合
            while (iter.hasNext()){
                SelectionKey key = iter.next();
                log.debug("key:{}",key);
                ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                SocketChannel sc = channel.accept();
                log.debug("{}",sc);
            }
        }
    }

}

