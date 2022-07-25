package com.jm.learning.chain;

import com.jm.learning.chain.demo01.*;
import com.jm.learning.chain.demo01.process.HandlerType;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        chainContext.setKey("one");
        ProcessChainMap chainMap = context.getBean(ProcessChainMap.class);
        chainMap.handle(chainContext);
    }
}
