package com.jm.learning.appevent.demo01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @author zhangfei
 * @date 2022/6/30 18:44
 **/
//@Configuration
//@Component
public class CommonConfig {
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setThreadNamePrefix("asyncEventExecutor-");
        taskExecutor.setCorePoolSize(4);
        taskExecutor.initialize();
        eventMulticaster.setTaskExecutor(taskExecutor);
        return eventMulticaster;
    }
}
