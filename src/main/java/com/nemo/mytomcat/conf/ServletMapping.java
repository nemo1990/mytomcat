package com.nemo.mytomcat.conf;

import com.nemo.mytomcat.servlet.MyServlet;
import lombok.Data;

@Data
public class ServletMapping {

    private String servletName;
    private String url;
    private String clazz;

    private Class<? extends MyServlet> myServletClazz;

    public ServletMapping(String servletName, String url, String clazz) {
        this.servletName = servletName;
        this.url = url;
        this.clazz = clazz;
    }

    public ServletMapping(String servletName, String url, Class<? extends MyServlet> clazz) {
        this.servletName = servletName;
        this.url = url;
        this.myServletClazz = clazz;
    }


}
