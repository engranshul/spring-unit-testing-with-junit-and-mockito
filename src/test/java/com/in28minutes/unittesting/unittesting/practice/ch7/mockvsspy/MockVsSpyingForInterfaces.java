package com.in28minutes.unittesting.unittesting.practice.ch7.mockvsspy;
import org.junit.jupiter.api.*;
import org.mockito.*;
import java.util.*;

// in case of interfaces(List here) both spy and mock behaves
// in a similar way..may be coz interfaces do not have any
// implementation

public class MockVsSpyingForInterfaces {

    @Test
    public void testMockForInterfaces() {
       System.out.println("******understanding mocking*******");
        List mockList = Mockito.mock(List.class);
        System.out.println(mockList.size());
        mockList.add(1618268162);
        System.out.println(mockList.size());
    }

    @Test
    public void testSpyForInterfaces() {
        System.out.println("******understanding spying*******");
        List spyList = Mockito.spy(List.class);
        System.out.println(spyList.size());
        spyList.add(127817281);
        System.out.println(spyList.size());
    }
}
