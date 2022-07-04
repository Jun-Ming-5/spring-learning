package com.jm.learning.chain;

import com.jm.learning.chain.demo01.ChainContext;
import com.jm.learning.chain.demo01.ProcessChainLoop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhangfei
 * @date 2022/7/4 17:54
 **/
@SpringBootApplication
public class ChainMainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ChainMainApplication.class, args);
        ProcessChainLoop chainLoop = context.getBean(ProcessChainLoop.class);
        ChainContext chainContext = new ChainContext();
        chainLoop.handle(chainContext);
    }
}
