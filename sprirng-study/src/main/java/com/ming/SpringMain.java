package com.ming;

import com.ming.bean.ExampleBean;
import com.ming.service.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        ExampleBean exampleBean=applicationContext.getBean(ExampleBean.class);
        System.out.println("------------------------");
        EmailService emailService=applicationContext.getBean(EmailService.class);
        emailService.sendEmail("john.doe@example.org","hhh");

    }
}
