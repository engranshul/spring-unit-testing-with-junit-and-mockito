package com.in28minutes.unittesting.unittesting.practice.ch4;

import com.in28minutes.unittesting.unittesting.practice.common.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

@ExtendWith(MockitoExtension.class)
public class BusinessImplTest {

    // BusinessImplV2 businessImplV2 = new BusinessImplV2();
    @InjectMocks
    BusinessImplV2 businessImplV2;


    // DataService mockImpl=Mockito.mock(DataService.class);
    // businessImplV2.setDataService(mockImpl);
    @Mock
    DataService dataServiceMockImpl;


    @Test
    public void addNosPositive() {
        Mockito.when(dataServiceMockImpl.retrieveData()).thenReturn(new int[]{100,33});
        Assertions.assertEquals(businessImplV2.add(),133);
    }
}
