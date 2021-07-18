package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.model.*;
import org.springframework.stereotype.*;
import java.util.*;


@Component
public class MyBusinessService {
    public List<SalesOrder> getAllSalesOrder() {
        List<SalesOrder> salesOrderList = new ArrayList<>();
        SalesOrder s1= new SalesOrder(1,"toys");
        SalesOrder s2= new SalesOrder(2,"clothes");
        salesOrderList.add(s1);
        salesOrderList.add(s2);
        return salesOrderList;
    }
}
