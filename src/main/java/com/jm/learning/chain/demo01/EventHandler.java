package com.jm.learning.chain.demo01;

public interface EventHandler<T> {
    int getIndex();
    void handle(T t);
}
