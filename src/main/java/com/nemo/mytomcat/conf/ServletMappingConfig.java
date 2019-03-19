package com.nemo.mytomcat.conf;

import com.nemo.mytomcat.servlet.impl.FindGirlServlet;
import com.nemo.mytomcat.servlet.impl.HelloWorldServlet;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
//        servletMappingList.add(new ServletMapping("findGirl", "/girl", "com.nemo.mytomcat.servlet.impl.FindGirlServlet"));
//        servletMappingList.add(new ServletMapping("helloWorld", "/world", "com.nemo.mytomcat.servlet.impl.HelloWorldServlet"));

        servletMappingList.add(new ServletMapping("findGirl", "/girl", FindGirlServlet.class));
        servletMappingList.add(new ServletMapping("helloWorld", "/world", HelloWorldServlet.class));
    }
}
