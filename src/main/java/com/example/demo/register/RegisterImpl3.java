package com.example.demo.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RegisterImpl3 implements Register {
    @Autowired
    RegisterImpl3(GenericApplicationContext applicationContext){
        System.out.println(applicationContext.getBeanDefinitionNames());
        System.out.println("in imp l3");
    }
}
