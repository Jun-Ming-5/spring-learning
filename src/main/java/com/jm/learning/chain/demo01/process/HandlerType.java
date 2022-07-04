package com.jm.learning.chain.demo01.process;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public  enum HandlerType{
    ONE("one",1),
    TWO("two",2);
    private String name;
    private int index;
}
