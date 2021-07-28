package com.example.demo.register;

import com.example.demo.register_list.MyListClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TestAutowired {

    @Autowired
    MyListClass myListClass;

    @Scheduled(fixedDelay = 10000)
    public void start(){
        System.out.println("___________________");
        System.out.println("Register implementation");
        myListClass.getList().forEach(System.out::println);
    }
}
