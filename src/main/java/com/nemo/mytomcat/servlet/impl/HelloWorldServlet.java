package com.nemo.mytomcat.servlet.impl;

import com.nemo.mytomcat.servlet.MyRequest;
import com.nemo.mytomcat.servlet.MyResponse;
import com.nemo.mytomcat.servlet.MyServlet;

import java.io.IOException;

public class HelloWorldServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get world...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post world...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
