package com.jm.learning.async;

import com.jm.learning.async.demo01.AsyncTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author zhangfei
 * @Date 2022/6/27 23:33
 */
@SpringBootApplication
@EnableAsync
public class MainApplicaton {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplicaton.class, args);
        AsyncTest bean = context.getBean(AsyncTest.class);
        System.out.println("bean..."+bean);
        bean.sendMessage();
    }
}
