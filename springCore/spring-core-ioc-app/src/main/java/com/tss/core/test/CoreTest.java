package com.tss.core.test;

import com.tss.core.config.AutoConfig;
import com.tss.core.entity.Computer;
import com.tss.core.entity.HardDisk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreTest {

    public static void main(String[] args) {

//        HardDisk hardDisk = new HardDisk(326);
//        Computer computer = new Computer("Apple", hardDisk);
//
//        System.out.println(computer);

        //this os for xml based configuration
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        //this will be for annotation based configuration

        ApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);

        Computer computer = context.getBean(Computer.class);

        System.out.println(computer);
    }
}
