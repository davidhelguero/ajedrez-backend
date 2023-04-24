package com.example.demo.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ATest {

    @Mock
    private B b;

    @InjectMocks
    private A a;
    private String[] arrayOfString;

    @BeforeEach
    void setUp() {
        arrayOfString = new String[]{"mate","cafe","harina","palmitos"};

    }

    @Test
    void join() {
        when(b.join(arrayOfString)).
        thenReturn("mate,cafe,harina,palmitos");

        assertEquals("mate,cafe,harina,palmitos", a.join(arrayOfString));
    }

    @Test
    void joinArrayNull() {
        when(b.join(arrayOfString)).thenReturn("mate,cafe,harina,palmitos");

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            a.join(null);
        });

        Assertions.assertEquals("Cannot join a null array", thrown.getMessage());
    }

    @Test
    void joinArrayEmpty() {
        when(b.join(arrayOfString)).thenReturn("");

        assertEquals("", a.join(arrayOfString));
    }

    @Test
    void joinArrayDistinct() {
        arrayOfString = new String[]{"mate", "cafe", "harina", "palmitos", "mate"};
        when(b.join(arrayOfString)).thenReturn("mate,cafe,harina,palmitos");

        assertEquals("mate,cafe,harina,palmitos", a.join(arrayOfString));
    }

    @Test
    void joinArraySorted() {
        arrayOfString = new String[]{"mate", "cafe", "harina", "palmitos"};
        when(b.join(arrayOfString)).thenReturn("cafe,harina,mate,palmitos");

        assertEquals("cafe,harina,mate,palmitos", a.join(arrayOfString));
    }
}