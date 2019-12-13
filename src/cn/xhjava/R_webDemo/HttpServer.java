package cn.xhjava.R_webDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Xiahu
 * @create 2019/12/1
 * @since 1.0.0
 */
public class HttpServer {
    public static void main(String[] args) throws IOException {
        //1.启动服务器,监听8888端口
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("服务器端口8888已经启动...");
        //使用线程池启动
        ExecutorService pool = Executors.newCachedThreadPool();
        while (!Thread.interrupted()) {
            //只要线程没中断,就不停的接收请求
            Socket client = ss.accept();
            pool.execute(new HttpServerThread(client));
        }
        pool.shutdown();


    }
}