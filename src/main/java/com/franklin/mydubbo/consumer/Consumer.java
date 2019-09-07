package com.franklin.mydubbo.consumer;


import com.franklin.mydubbo.framework.ProxyFactory;
import com.franklin.mydubbo.provider.service.api.HelloService;

/**
 * @author Kirby
 * @date 2019/9/7 0007 14:35
 */
public class Consumer {
    
    public static void main(String[] args){
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("My name is Kirby");
        System.out.println(result);

        System.err.println("-----------------");

//        System.out.println(helloService.helloPerson(2));
    }
}
