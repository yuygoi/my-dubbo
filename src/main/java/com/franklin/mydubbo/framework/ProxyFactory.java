package com.franklin.mydubbo.framework;

import com.franklin.mydubbo.framework.protocol.Protocol;
import com.franklin.mydubbo.framework.protocol.ProtocolFactory;
import com.franklin.mydubbo.protocol.http.HttpProtocol;
import com.franklin.mydubbo.register.Registery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Kirby
 * @date 2019/9/7 0007 14:46
 */
public class ProxyFactory<T> {

    public static <T> T getProxy(Class interfaceClass){

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Protocol protocol = ProtocolFactory.getProtocol();
                        Invocation invocation = new Invocation(
                                interfaceClass.getName(),
                                method.getName(),
                                args,
                                method.getParameterTypes());
                        URL url = Registery.randomBalance(interfaceClass.getName());
                        System.err.println("service comes from " + url.getHostName() + ":" + url.getPort());
                        return protocol.send(url,invocation);
                    }
                });
    }
}
