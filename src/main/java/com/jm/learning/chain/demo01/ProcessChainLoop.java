package com.jm.learning.chain.demo01;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangfei
 * @date 2022/7/4 17:44
 **/
@Component
public class ProcessChainLoop implements ProcessChain<ChainContext> {

    private List<EventHandler<ChainContext>> handlers;

    public ProcessChainLoop(List<EventHandler<ChainContext>> handlers) {
        this.handlers = handlers.stream().sorted(Comparator.comparing(EventHandler::getIndex)).collect(Collectors.toList());
    }

    @Override
    public void handle(ChainContext chainContext) {
        for (EventHandler<ChainContext> eventHandler : handlers) {
            eventHandler.handle(chainContext);
        }
    }
}
