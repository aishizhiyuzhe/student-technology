package com.ming.springtask.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringTask {

    @Scheduled(cron = "0/2 * * * * ? ")
    public void task(){
        System.out.print("循环task执行");
    }
}
