package com.in28minutes.unittesting.unittesting.practice.ch1;

public class BusinessImplV1 {
    // in real world many a times we don't get this data(input) directly..lets
    // implement it on ch2
    public int add(int ...input) {
        int sum =0;
        for(int val : input) {
            sum+=val;
        }
        return sum;
    }
}
