package com.franklin.mydubbo.protocol.http;

import com.franklin.mydubbo.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Kirby
 * @date 2019/9/7 0007 14:20
 */
public class HttpClient {

    public Object post(String hostName, Integer port, Invocation invocation){
        ObjectOutputStream oos = null;
        try {
            URL url = new URL("http",hostName,port,"/");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            OutputStream outputStream = urlConnection.getOutputStream();
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(invocation);
            oos.flush();

            InputStream inputStream = urlConnection.getInputStream();
            return IOUtils.toString(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
