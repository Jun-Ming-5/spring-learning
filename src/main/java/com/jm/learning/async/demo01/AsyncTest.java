package com.jm.learning.async.demo01;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhangfei
 * @Date 2022/6/27 23:35
 */
@Component
public class AsyncTest {

    @Autowired
    private Sender sender;

//    @Autowired   //Q1
//    private AsyncTest asyncTest;

    public AsyncTest(){
        System.out.println("AsyncTest Constructor");
    }


    @Async //Q2
    @SneakyThrows
    public void sendMessage() {
        System.out.println("send message before " + LocalDateTime.now());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("send message...");
        System.out.println("send message end " + LocalDateTime.now());
    }

    @SneakyThrows
    public void doSomething() {
        System.out.println("do something start " + LocalDateTime.now());
        System.out.println("do something ....");
        sendMessage();          //Q3 为什么这儿没有异步效果
        //asyncTest.sendMessage(); //Q4
        sender.sendMessage();     //为什么这儿有异步效果，是不是很眼熟，对：就是和@Transactional效果一样
        System.out.println("do something end " + LocalDateTime.now());
    }

    @Component
    public static class Sender {
        @Async
        @SneakyThrows
        public void sendMessage() {
            System.out.println("send message before " + LocalDateTime.now());
            TimeUnit.SECONDS.sleep(3);
            System.out.println("send message...");
            System.out.println("send message end " + LocalDateTime.now());
        }
    }

    /**
     * 灵魂拷问：
     * Q3为什么没有异步效果
     * 打开Q1注释为什么会有循环引用,spring天生就能解决循环引用，为什么这儿不行
     * 将Q2注释Q4放开为什么没有循环引用的问题
     *
     *
     */
}
