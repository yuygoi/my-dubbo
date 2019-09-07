package com.franklin.mydubbo.protocol.http;

import com.franklin.mydubbo.framework.Invocation;
import com.franklin.mydubbo.framework.URL;
import com.franklin.mydubbo.register.Registery;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;

/**
 * @author Kirby
 * @date 2019/9/7 0007 11:26
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream ois = null;
        try {
            InputStream inputStream = req.getInputStream();
            ois = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) ois.readObject();

            //TODO 找接口实现类
            String interfaceName = invocation.getInterfaceName();
            URL url = new URL("localhost", 8081);
            Class implCLass = Registery.getImpl(url, interfaceName);

            Method method = implCLass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            Object result = method.invoke(implCLass.newInstance(), invocation.getParams());

            OutputStream outputStream = resp.getOutputStream();

            IOUtils.write(result.toString(),outputStream,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
