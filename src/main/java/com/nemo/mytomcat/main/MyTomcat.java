package com.nemo.mytomcat.main;

import com.nemo.mytomcat.servlet.MyRequest;
import com.nemo.mytomcat.servlet.MyResponse;
import com.nemo.mytomcat.conf.ServletMapping;
import com.nemo.mytomcat.conf.ServletMappingConfig;
import com.nemo.mytomcat.servlet.MyServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat {

    private int port = 8080;

    private Map<String, String> urlServletMap = new HashMap<>();

    private Map<String, Class<? extends MyServlet>> urlServletClassMap = new HashMap<>();

    public MyTomcat(int port) {
        this.port = port;
    }

    public void start() {
        //初始化url与对应处理的servlet的关系
        initServletMapping();

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("myTomcat is start...");

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                //请求分发
                dispatch(myRequest, myResponse);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initServletMapping() {
        for(ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
//            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
            urlServletClassMap.put(servletMapping.getUrl(), servletMapping.getMyServletClazz());
        }
    }

    private void dispatch(MyRequest myRequest, MyResponse myResponse) {
//        String clazz = urlServletMap.get(myRequest.getUrl());

        Class<? extends MyServlet> myServletClazz = urlServletClassMap.get(myRequest.getUrl());

        //反射
        try {
//            if(clazz == null) {
            if(myServletClazz == null) {
                myResponse.write("FUCK");
                return;
            }

//            Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
//            MyServlet myServlet = myServletClass.newInstance();

            MyServlet myServlet = myServletClazz.newInstance();

                    myServlet.service(myRequest, myResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyTomcat(8080).start();
    }
}
