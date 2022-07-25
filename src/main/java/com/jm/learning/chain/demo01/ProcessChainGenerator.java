package com.jm.learning.chain.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangfei
 * @date 2022/7/5 10:56
 **/
//@Component
public class ProcessChainGenerator {
    @Autowired
    private List<EventHandler> handlers;

    public  ProcessChain createProcessChain(List<String> keys){
       // List<EventHandler> collect = handlers.stream().filter(e -> keys.contains(e.getKey())).collect(Collectors.toList());
      //  return new ProcessChainLoop(collect);
        return null;
    }
}
