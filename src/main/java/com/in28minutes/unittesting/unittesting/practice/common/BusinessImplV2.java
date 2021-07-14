package com.in28minutes.unittesting.unittesting.practice.common;

public class BusinessImplV2 {

    private DataService dataService;

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public int add() {
        int sum =0;
        int[] input =  dataService.retrieveData();
        for(int val : input) {
            sum+=val;
        }
        return sum;
    }
}
