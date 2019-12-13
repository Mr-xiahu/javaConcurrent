package cn.xhjava.R_webDemo;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiahu
 * @create 2019/12/1
 * @since 1.0.0
 */
public class HttpServerThread implements Runnable {
    private Socket client;
    private InputStream ips;
    private OutputStream ops;
    private PrintWriter pw;
    private static final String WEB_ROOT = "D:\\webroot\\";
    private static Map<String, String> contentTypeMap = new HashMap<>();


    static {
        contentTypeMap.put("html", "text/html");
        contentTypeMap.put("jpg", "image/jpeg");
    }

    public HttpServerThread(Socket client) {
        this.client = client;
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        ips = client.getInputStream();
        ops = client.getOutputStream();
    }


    @Override
    public void run() {
        try {
            go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(ips));
        String line = br.readLine().split(" ")[1].replace("/", "\\");
        if (line.equals("\\")) {
            line += "index.html";
        }
        pw = new PrintWriter(ops);
        //响应回前端页面的数据
        InputStream is = new FileInputStream(WEB_ROOT + line);
        System.out.println(line);
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: " + contentTypeMap.get(line.substring(line.lastIndexOf(".") + 1, line.length())) + ";charset=utf-8");
        pw.println("Content-Lenth: " + is.available());
        pw.println("Server: XiaHu");
        pw.println();
        pw.flush();
        byte[] bys = new byte[1024];
        int length = 0;
        while ((length = is.read(bys)) != -1) {
            ops.write(bys, 0, length);
        }
        is.close();
        pw.flush();
        pw.close();
        br.close();
        client.close();


    }
}