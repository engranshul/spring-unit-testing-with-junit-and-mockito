package com.in28minutes.unittesting.unittesting.practice.ch6.practiceofallconcepts;

import java.util.*;

public class Calculator implements Operation {

    private DBRetriever dbRetriever;

    public void setDbRetriever(DBRetriever dbRetriever) {
        this.dbRetriever = dbRetriever;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("performing addition..");
        return a+b;
    }

    @Override
    public int mul() {
        System.out.println("performing multiplication..");
        List<Integer> dataList= dbRetriever.getData();
        int result =1;
        for(int num: dataList) {
            result = result * num;
        }
        return result;
    }


    @Override
    public String printSuccessMsg(String team,String msg) {
        return team + msg +dbRetriever.getRemainingMsg(team,msg);
    }

    public   interface DBRetriever {
        List<Integer> getData();
        String getRemainingMsg(String team, String msg);
    }
}
