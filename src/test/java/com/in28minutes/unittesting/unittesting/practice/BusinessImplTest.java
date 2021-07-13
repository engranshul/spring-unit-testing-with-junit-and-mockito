package com.in28minutes.unittesting.unittesting.practice;

import org.junit.jupiter.api.*;

public class BusinessImplTest {

    @Test
    public void addNos() {
        BusinessImpl businessImpl = new BusinessImpl();
        int actual =businessImpl.add(278,344,212,2223,33);
        Assertions.assertEquals(actual,3090);
    }
}
