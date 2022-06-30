package com.jm.learning.appevent;

import com.jm.learning.appevent.demo01.ApplicationEventTest01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhangfei
 * @date 2022/6/30 17:02
 **/
@SpringBootApplication
public class AppEventMainApplicaiton {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppEventMainApplicaiton.class, args);
        ApplicationEventTest01 bean = context.getBean(ApplicationEventTest01.class);
        System.out.println("bean..."+bean);
        bean.publish();
    }
}
