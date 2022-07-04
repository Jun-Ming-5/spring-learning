package com.jm.learning.chain.demo01;

/**
 * @author zhangfei
 * @date 2022/7/4 17:08
 **/
public interface ProcessChain<T>{
    void handle(T chainContext);
}
