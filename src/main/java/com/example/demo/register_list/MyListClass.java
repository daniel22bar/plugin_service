package com.example.demo.register_list;

import com.example.demo.register.Register;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class MyListClass implements ListClass{
    private List<Register> list = new ArrayList<>();

    public MyListClass() {
    }

    public void addToList(Register registerImplToAdd){
        list.add(registerImplToAdd);
    }

    public void register(Register registerImplToAdd){
        if(!list.contains(registerImplToAdd))
            addToList(registerImplToAdd);
        else
            System.out.println("this class already registered: " + registerImplToAdd.getClass());
    }



}
