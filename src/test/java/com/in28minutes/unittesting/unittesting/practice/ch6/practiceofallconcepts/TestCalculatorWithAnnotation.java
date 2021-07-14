package com.in28minutes.unittesting.unittesting.practice.ch6.practiceofallconcepts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class TestCalculatorWithAnnotation {

    @Mock
    Calculator.DBRetriever dbRetrieverMock;

    @InjectMocks
    Calculator myCalculator;

    @Test
    public void testAddMethod() {
        Calculator myCalculator = new Calculator();
        Assertions.assertEquals(40,myCalculator.add(17,23));
    }

    @Test
    public void testMulMethod() {
        // removed below 3 lines and added annotation for them
        // Calculator myCalculator = new Calculator();
        // Calculator.DBRetriever dbRetrieverMock= Mockito.mock(Calculator.DBRetriever.class);
        // myCalculator.setDbRetriever(dbRetrieverMock);  // this means that this Calculator has mock DBRetriever

        Mockito.when(dbRetrieverMock.getData()).thenReturn(List.of(1,2,3,3));
        Assertions.assertEquals(18,myCalculator.mul());
        Assertions.assertEquals(18,myCalculator.mul());
        // Assertions.assertEquals(18,myCalculator.mul());
        Mockito.verify(dbRetrieverMock,Mockito.atMost(2)).getData();
    }
}
