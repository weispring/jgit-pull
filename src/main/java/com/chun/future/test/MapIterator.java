package com.chun.future.test;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 *  测试jvm变量
 *  map 循环java.util.ConcurrentModificationException
 *  局部变量
 * Created by lixianchun on 2018/7/24.
 **/
@Slf4j
public class MapIterator {

    public static void main(String[] args) {
       /* System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");     //系统的最大空间

        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");   //系统的空闲空间

        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");   //当前可用的总空间
*/


        MapIterator common = new MapIterator();
        TestParam testParam = new TestParam();
        testParam.setId("33");
        common.test(testParam);
        System.out.println(testParam);

        final HashMap map = JSONObject.parseObject("{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\",\"key4\":\"value4\",\"key5\":\"value5\",\"key6\":\"value6\"}",HashMap.class);

       /* new Thread(new Runnable() {
            public void run() {
                for (Object key : map.keySet()){
                    map.remove(key);
                }
            }
        }).start();*/
       ;


       //下面两种正确
    /*   java.util.Iterator iterable = map.keySet().iterator();
       for (Object key : map.keySet()){
           Object temp = iterable.next();
          iterable.remove();
       }*/
       Long la = new Long(100);
       if ("".equals(la)){
           log.info("");
       }
/*

        for (String key : map.keySet()) {
            if (null == map.get(key)) {
                map.put(key, "");
            }
        }
*/


/*
        下面2种情况 map 循环修改了，modcount
        for (Object key : map.keySet()){
            map.remove(key);
        }

         for (Object key : map.keySet()){
            map.put(key + "1","");
        }

        */





    }

    public void test(TestParam testParam){
        //testParam = null; 局部变量
        testParam.setId("dd");
    }
}
