package com.in28minutes.unittesting.unittesting.practice.ch2;

import com.in28minutes.unittesting.unittesting.practice.common.*;
import org.junit.jupiter.api.*;

public class BusinessImplTest {
    @Test
    public void addNosPositive() {
         BusinessImplV2 businessImplV2 = new BusinessImplV2();
         businessImplV2.setDataService(new MockClassForPositiveTestCase());
        Assertions.assertEquals(businessImplV2.add(),12);
    }
    @Test
    public void addNosNegative() {
        BusinessImplV2 businessImplV2 = new BusinessImplV2();
        businessImplV2.setDataService(new MockClassForNegativeTestCase());
        Assertions.assertEquals(businessImplV2.add(),0);
    }

    // prob wd this approach is that : mock classes will increase as
    // for each type of test data..can we avoid creating some many
    // classes ??..also if new method is added in DataService interface
    // all mock classes will have compilation error..
    private static class MockClassForPositiveTestCase implements DataService {
        @Override
        public int[] retrieveData() {
            return new int[] {1,2,3,3,3};
        }
    }
    private static class MockClassForNegativeTestCase implements DataService {
        @Override
        public int[] retrieveData() {
            return new int[] {};
        }
    }
}
