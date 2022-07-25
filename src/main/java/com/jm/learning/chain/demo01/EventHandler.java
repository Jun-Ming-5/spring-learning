package com.jm.learning.chain.demo01;

public interface EventHandler<T> {
    default int getIndex(){throw new IllegalStateException("不支持调用方式");}
    default String getKey(){throw new IllegalStateException("不支持调用方式");}
    void handle(T t);
}
