package com.in28minutes.unittesting.unittesting.practice.ch6.practiceofallconcepts;

import org.junit.jupiter.api.*;
import org.mockito.*;
import java.util.*;

public class TestCalculator {

    // simple plain vanilla testcase..does nt require any mocking
    // as input is taken via parameters in add method


    @Test
    public void testAddMethod() {
        Calculator myCalculator = new Calculator();
        Assertions.assertEquals(40,myCalculator.add(17,23));
    }
    // mul calls DB to get data..i do not want to get wd DB for my
    // silly testcase..lets mock DB
    @Test
    public void testMulMethod() {
        Calculator myCalculator = new Calculator();
        Calculator.DBRetriever dbRetrieverMock=Mockito.mock(Calculator.DBRetriever.class);
        myCalculator.setDbRetriever(dbRetrieverMock);  // this means that this Calculator has mock DBRetriever

        Mockito.when(dbRetrieverMock.getData()).thenReturn(List.of(1,2,3,3));
        Assertions.assertEquals(18,myCalculator.mul());
        Assertions.assertEquals(18,myCalculator.mul());
        Assertions.assertEquals(18,myCalculator.mul());
        // will give exception wd msg : Wanted at most 2 times but was 3
        Mockito.verify(dbRetrieverMock,Mockito.atMost(2)).getData();
    }
}
