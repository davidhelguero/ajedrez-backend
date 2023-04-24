package com.example.demo.mockito;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class B {

    public String join(String[] arrayOfString){
        return Arrays.asList(arrayOfString)
                .stream()
                .collect(Collectors.joining(","));
    }


}
