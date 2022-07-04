package com.jm.learning.chain.demo01.process;

import com.jm.learning.chain.demo01.ChainContext;
import com.jm.learning.chain.demo01.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @author zhangfei
 * @date 2022/7/4 17:56
 **/
@Component
public class HandlerOne implements EventHandler<ChainContext> {

    @Override
    public int getIndex() {
        return HandlerType.ONE.getIndex();
    }

    @Override
    public void handle(ChainContext chainContext) {
        System.out.println("handler one......");
    }
}
