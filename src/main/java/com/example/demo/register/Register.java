package com.example.demo.register;

import com.example.demo.register_list.ListClass;
import org.springframework.beans.factory.annotation.Autowired;


public interface Register {

    @Autowired
     default void func(ListClass myListClass){
        myListClass.register(this);
    }
}
