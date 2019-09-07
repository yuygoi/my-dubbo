package com.franklin.mydubbo.provider;

import com.franklin.mydubbo.framework.protocol.Protocol;
import com.franklin.mydubbo.framework.URL;
import com.franklin.mydubbo.framework.protocol.ProtocolFactory;
import com.franklin.mydubbo.provider.service.api.HelloService;
import com.franklin.mydubbo.provider.service.impl.HelloServiceImpl;
import com.franklin.mydubbo.register.Registery;

/**
 * @author Kirby
 * @date 2019/9/7 0007 11:36
 */
public class Provider {
    
    public static void main(String[] args){
        //service register
        URL url = new URL("localhost", 8081);
        Registery.regist(url, HelloService.class.getName(), HelloServiceImpl.class);

        //start server
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }
}
