package com.in28minutes.unittesting.unittesting.practice.ch1;

import org.junit.jupiter.api.*;

public class BusinessImplTest {

    @Test
    public void addNos() {
        BusinessImplV1 businessImplV1 = new BusinessImplV1();
        int actual =businessImplV1.add(278,344,212,2223,33);
        Assertions.assertEquals(actual,3090);
    }
}
