package com.in28minutes.unittesting.unittesting.practice.ch5;

import com.in28minutes.unittesting.unittesting.practice.common.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

public class VerificationBasics {

    @Test
    public void verifyIfCalled() {
        DataService dataServiceMockImpl = Mockito.mock(DataService.class);
        BusinessImplV2 businessImplV2 = new BusinessImplV2();
        businessImplV2.setDataService(dataServiceMockImpl);

        Mockito.when(dataServiceMockImpl.retrieveData())
        .thenReturn(new int[] {1,2,3});
        Assertions.assertEquals(6,businessImplV2.add());
        Mockito.verify(dataServiceMockImpl,Mockito.times(1)).retrieveData();
}}
