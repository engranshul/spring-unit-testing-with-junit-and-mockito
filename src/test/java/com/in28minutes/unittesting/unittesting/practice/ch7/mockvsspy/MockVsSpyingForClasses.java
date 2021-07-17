package com.in28minutes.unittesting.unittesting.practice.ch7.mockvsspy;

import org.junit.jupiter.api.*;
import org.mockito.*;
import java.util.*;

// in case of classes(ArrayList here) both spy and mock behave
// differently..spy copy code..mock doesn't copy code

// override works similarly in both mock and spy
public class MockVsSpyingForClasses {
    @Test
    public void testMockForClasses() {
        System.out.println("******understanding mocking*******");
        ArrayList mockArrayList = Mockito.mock(ArrayList.class);
        System.out.println(mockArrayList.size());
        mockArrayList.add(1618268162);
        System.out.println(mockArrayList.size());
        // lets override behaviour
        Mockito.when(mockArrayList.get(Mockito.anyInt())).thenReturn("mockkkiinnggg");
        System.out.println(mockArrayList.get(340));
        System.out.println(mockArrayList.get(6760));

        // verification
        Mockito.verify(mockArrayList,Mockito.atLeast(2)).get(Mockito.anyInt());
    }

    @Test
    public void testSpyForClasses() {
        System.out.println("******understanding spying*******");
        ArrayList spyArrayList = Mockito.spy(ArrayList.class);
        System.out.println(spyArrayList.size());
        spyArrayList.add(127817281);
        System.out.println(spyArrayList.size());
        // lets override behaviour
        Mockito.when(spyArrayList.get(Mockito.anyInt())).thenReturn("spyinnggggg");
        System.out.println(spyArrayList.get(780));

        // verification
        Mockito.verify(spyArrayList,Mockito.atLeast(0)).get(Mockito.anyInt());
    }
}
