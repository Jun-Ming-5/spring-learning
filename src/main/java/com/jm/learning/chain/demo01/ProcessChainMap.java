package com.jm.learning.chain.demo01;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhangfei
 * @date 2022/7/4 17:44
 **/
@Component
public class ProcessChainMap implements ProcessChain<ChainContext> {

    private Map<String,EventHandler<ChainContext>> map;

    public ProcessChainMap(List<EventHandler<ChainContext>> handlers) {
        map = handlers.stream().collect(Collectors.toMap(EventHandler::getKey, Function.identity()));
    }
    @Override
    public void handle(ChainContext chainContext) {
        if(map.containsKey(chainContext.getKey())){
            map.get(chainContext.getKey()).handle(chainContext);
            handle(chainContext);
        }
    }
}
