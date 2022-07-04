package com.jm.learning.appevent.demo01;

import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangfei
 * @date 2022/6/30 16:55
 **/
@Component
public class ApplicationEventTest01 {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publish(){
        InnerEventData data = new InnerEventData();
        data.content = "hello world";
        eventPublisher.publishEvent(data);
        System.out.println("publish over");
    }

    @SneakyThrows
    @EventListener
    @Order(2)
    public void consume01(InnerEventData data){
        System.out.println("data1:"+data);
        //TimeUnit.SECONDS.sleep(3);
    }

    @SneakyThrows
    @EventListener
    @Order(1)
    public void consume02(InnerEventData data){
        System.out.println("data2:"+data);
        //TimeUnit.SECONDS.sleep(3);
    }

    @Data
    public static class InnerEventData{
        private String content;
    }
}
