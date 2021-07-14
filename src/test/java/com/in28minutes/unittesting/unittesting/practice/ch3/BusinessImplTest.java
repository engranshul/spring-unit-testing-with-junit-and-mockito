package com.in28minutes.unittesting.unittesting.practice.ch3;

import com.in28minutes.unittesting.unittesting.practice.common.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

public class BusinessImplTest {
    @Test
    public void addNosPositive() {
        BusinessImplV2 businessImplV2 = new BusinessImplV2();
        // way to create mock impl out of an interface
        DataService mockImpl=Mockito.mock(DataService.class);
        // way to provide trigger and desired output on mock impl
        Mockito.when(mockImpl.retrieveData()).thenReturn(new int[]{100,33});
        businessImplV2.setDataService(mockImpl);
        Assertions.assertEquals(businessImplV2.add(),133);
    }
}
