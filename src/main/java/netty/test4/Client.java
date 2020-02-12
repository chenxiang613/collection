package netty.test4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        //https://www.cnblogs.com/miller-zou/p/7000553.html
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                     .channel(NioSocketChannel.class)
                     .handler(new ClientInitializer());
            
            Channel channel = bootstrap.connect("localhost", 8989).sync().channel();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for(;;){
                channel.writeAndFlush(reader.readLine() + "\n");
            }
        }finally{
            eventLoopGroup.shutdownGracefully(); //优雅关闭
        }
    }
}