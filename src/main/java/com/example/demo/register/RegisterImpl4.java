package com.example.demo.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RegisterImpl4 implements Register {
    @Autowired
    RegisterImpl4(GenericApplicationContext applicationContext){
        System.out.println(applicationContext.getBeanDefinitionNames());
        System.out.println("in imp 4");
    }
}
