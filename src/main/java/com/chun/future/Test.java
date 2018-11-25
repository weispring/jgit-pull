package com.chun.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 测试异步回调
 * Created by lixianchun on 2018/7/25.
 **/
@Slf4j
public class Test {
    public static void main(String[] args) throws Exception{
        String queryStr = "query";
        //构造FutureTask 并传入需要正在进行业务逻辑处理的类
        //该类一定是实现了Callable接口的类
        FutureTask<Object> future = new FutureTask<Object>(new MyFuture());


        //创建一个固定线程的线程池 数量为1
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //这里提交任务future 则开发线程RealData的call（）方法执行
        //submit 和execute的区别 第一点是submit可以传入实现Callable接口的实例对象
        //第二点是submit方法有返回值

        Future f1 = executor.submit(future);//单独启动一个线程

        System.out.println("请求完毕");

        try{
            //这里可以做额外的数据操作 也就是主程序执行其他业务
            System.out.println("处理实际的业务逻辑");
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("获取线程执行结果前：");
        //调用获取数据方法 如果call()方法没有执行完成 则会进行等待
        System.out.println("数据" + future.get().toString());




        executor.shutdown();
    }
}
