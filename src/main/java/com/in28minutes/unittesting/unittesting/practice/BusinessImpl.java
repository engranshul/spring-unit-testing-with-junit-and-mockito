package com.in28minutes.unittesting.unittesting.practice;

public class BusinessImpl {
    public int add(int ...input) {
        int sum =0;
        for(int val : input) {
            sum+=val;
        }
        return sum;
    }
}
