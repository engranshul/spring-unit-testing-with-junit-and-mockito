package com.in28minutes.unittesting.unittesting.practice.ch6.practiceofallconcepts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

@ExtendWith(MockitoExtension.class)
public class TestArgumentCapturing {

    @Mock
    Calculator.DBRetriever dbRetrieverMock;

    @InjectMocks
    Calculator myCalculator;

    @Test
    public void testArgumentCapturingForPrintMsg() {
        Mockito.when(dbRetrieverMock.getRemainingMsg("logistics","u have done impossible")).thenReturn("chak de phatte");
        Assertions.assertEquals("logisticsu have done impossiblechak de phatte",myCalculator.printSuccessMsg("logistics","u have done impossible"));
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(dbRetrieverMock).getRemainingMsg(stringArgumentCaptor.capture(),stringArgumentCaptor.capture());
        Assertions.assertEquals("[logistics, u have done impossible]",stringArgumentCaptor.getAllValues().toString());
    }
}
