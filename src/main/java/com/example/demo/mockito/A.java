package com.example.demo.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class A {
    private B b;

    @Autowired
    public A(B b) {
        this.b = b;
    }

    public String join(String[] arrayOfString){
        if(arrayOfString == null)
            throw new RuntimeException("Cannot join a null array");

        Arrays.stream(arrayOfString).distinct();
        Arrays.stream(arrayOfString).sorted();

        return b.join(arrayOfString);
    }
}
