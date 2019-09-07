package com.franklin.mydubbo.framework.protocol;

import com.franklin.mydubbo.framework.enums.Protocols;
import com.franklin.mydubbo.protocol.dubbo.DubboProtocol;
import com.franklin.mydubbo.protocol.http.HttpProtocol;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Kirby
 * @date 2019/9/7 0007 15:52
 */
public class ProtocolFactory {

    private static Properties properties;

    static {
        InputStream inputStream = null;
        properties = new Properties();
        try {
            inputStream = new FileInputStream("src/main/java/com/franklin/mydubbo/framework/internal/Protocol.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //factory mode
    public static Protocol getProtocol(){
        String protocolName = properties.getProperty("defaultProtocol");
        if (StringUtils.isBlank(protocolName)){
            protocolName = Protocols.Http.value();
        }
        String classPath = properties.getProperty(protocolName);
        try {
            Class clazz = Class.forName(classPath);
            return (Protocol) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
