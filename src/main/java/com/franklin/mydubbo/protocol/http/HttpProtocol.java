package com.franklin.mydubbo.protocol.http;

import com.franklin.mydubbo.framework.Invocation;
import com.franklin.mydubbo.framework.protocol.Protocol;
import com.franklin.mydubbo.framework.URL;

/**
 * @author Kirby
 * @date 2019/9/7 0007 15:29
 */
public class HttpProtocol implements Protocol {



    @Override
    public void start(URL url) {
        //start tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(),url.getPort());
    }

    @Override
    public Object send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.post(url.getHostName(),url.getPort(),invocation);
    }
}
