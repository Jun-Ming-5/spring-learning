package com.jm.learning.async.demo01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangfei
 * @date 2022/7/8 9:55
 **/
@Configuration
public class Config {

    @Bean("kafkaEventTaskExecutor") // bean的名称，默认为首字母小写的方法名
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(30);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(5000);
        executor.setKeepAliveSeconds(5);
        executor.setThreadNamePrefix("Async-Kafka-Event-Handle");
        executor.setRejectedExecutionHandler(null);
        executor.initialize();
        return executor;
    }
}
