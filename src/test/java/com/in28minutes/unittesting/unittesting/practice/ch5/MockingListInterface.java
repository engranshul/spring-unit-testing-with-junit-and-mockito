package com.in28minutes.unittesting.unittesting.practice.ch5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class MockingListInterface {

    @Mock
    List listMock;

    @Test
    public void mockListSizeMethod() {
        Mockito.when(listMock.size()).thenReturn(10).thenReturn(20);
        assertEquals(10,listMock.size());
        assertEquals(20,listMock.size());
        assertEquals(20,listMock.size(),"size assertion not passed");
    }

    @Test
    public void mockAssertEquals() {
         Mockito.when(listMock.get(0)).thenReturn("anshul is champion");
         assertEquals("anshul is champion",listMock.get(0));
    }

    @Test
    public void argumentMatchers() {
        Mockito.when(listMock.get(anyInt())).thenReturn("anshul is champion");
        assertEquals("anshul is champion",listMock.get(0));
        assertEquals("anshul is champion",listMock.get(Integer.MAX_VALUE+1));
    }
}
