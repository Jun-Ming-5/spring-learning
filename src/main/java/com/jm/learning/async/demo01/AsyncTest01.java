package com.jm.learning.async.demo01;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhangfei
 * @Date 2022/6/27 23:35
 */
@Component
public class AsyncTest01 {

    public AsyncTest01(){
        System.out.println("AsyncTest Constructor");
    }
    @Async
    @Transactional(rollbackFor = Exception.class)
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
        sendMessage(); //不循环依赖，为什么
        System.out.println("do something end " + LocalDateTime.now());
    }
}
