package com.jm.learning.chain.demo01.process;

import com.jm.learning.chain.demo01.ChainContext;
import com.jm.learning.chain.demo01.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @author zhangfei
 * @date 2022/7/4 17:57
 **/
@Component
public class HandlerTwo implements EventHandler<ChainContext> {

    @Override
    public int getIndex() {
        return HandlerType.TWO.getIndex();
    }

    @Override
    public String getKey() {
        return HandlerType.TWO.getName();
    }

    @Override
    public void handle(ChainContext chainContext) {
        System.out.println("handler two......");
        chainContext.setKey("over");
    }
}
