package com.chun.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * Created by lixianchun on 2018/7/26.
 **/

@Slf4j
public class MyFuture implements Callable<Object> {
    public Object call() throws Exception {
        Thread.currentThread().sleep(3000);
        log.info("测试kkk");
        return "测试数据";
    }
}
