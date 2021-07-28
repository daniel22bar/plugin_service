package com.example.demo.controller;

import com.example.demo.model.BeanToAdd;
import com.example.demo.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/regbean")
    public String regBean(@RequestBody BeanToAdd bean){
        registerService.addClassToProject(bean);
        return "class was added";
    }

}
