package com.example.demo.services;

import com.example.demo.load_class.MyClassLoader;
import com.example.demo.model.BeanToAdd;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Component
public class RegisterService {
    @Autowired
    private MyClassLoader classLoader;

    @Autowired
    GenericApplicationContext applContext;

    @SneakyThrows
    public void addClassToProject(BeanToAdd bean){


        Class<?> beanClass = classLoader.findClass( bean.getBeanClassRelativePath());
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry)applContext.getBeanFactory();
        GenericBeanDefinition beanDef = new GenericBeanDefinition();
        beanDef.setScope(BeanDefinition.SCOPE_SINGLETON);
        beanDef.setBeanClass(beanClass);
        beanFactory.registerBeanDefinition(bean.getBeanName(), beanDef);
        applContext.getBean(bean.getBeanName());
   }


}
