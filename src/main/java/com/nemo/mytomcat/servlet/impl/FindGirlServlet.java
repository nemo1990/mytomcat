package com.nemo.mytomcat.servlet.impl;

import com.nemo.mytomcat.servlet.MyRequest;
import com.nemo.mytomcat.servlet.MyResponse;
import com.nemo.mytomcat.servlet.MyServlet;

import java.io.IOException;

public class FindGirlServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
