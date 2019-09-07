package com.franklin.mydubbo.register;

import com.franklin.mydubbo.framework.URL;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Kirby
 * @date 2019/9/7 0007 11:07
 */
public class Registery {

    private final static String REGISTER_PATH = "registry.txt";

    private static Random random = new Random();

//    private static AtomicInteger robinIndex = new AtomicInteger();

    private static Map<String, Map<URL, Class>> REGISTERY = new HashMap<>();

    public static void regist(URL url, String interfaceName, Class implClass){
        HashMap<URL, Class> map = new HashMap<>();
        map.put(url,implClass);
        REGISTERY.put(interfaceName,map);
        saveFile();
    }

    private static void saveFile() {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(REGISTER_PATH);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTERY);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Class getImpl(URL url,String interfaceName){
        REGISTERY = getFile();
        return REGISTERY.get(interfaceName).get(url);
    }
    
    private static Map<String, Map<URL, Class>> getFile(){
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(REGISTER_PATH);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, Map<URL, Class>>)objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static URL getService(String interfaceName){
        return null;
    }

    /**
     * loadBalance -- Random
     */
    public static URL randomBalance(String interfaceName){
        REGISTERY = getFile();
        URL[] urls = REGISTERY.get(interfaceName).keySet().toArray(new URL[0]);
        int randomIndex = random.nextInt(urls.length);
        return urls[randomIndex];
    }

    /**
     * loadBalance -- in turns
     */
//    public static URL roundRobinBalance (String interfaceName){
//        URL[] urls = REGISTERY.get(interfaceName).keySet().toArray(new URL[0]);
//        int randomIndex = random.nextInt(urls.length);
//        return urls[randomIndex];
//    }


}
