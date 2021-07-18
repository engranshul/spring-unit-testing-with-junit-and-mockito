package com.in28minutes.unittesting.unittesting.controller;

import com.in28minutes.unittesting.unittesting.business.*;
import com.in28minutes.unittesting.unittesting.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class MyControllerReturningObject {

       @Autowired
       private MyBusinessService businessService;

        @GetMapping("/get-sales-order")
        public List<SalesOrder> myApi() {
            List<SalesOrder> salesOrderList = new ArrayList<>();
            SalesOrder s1= new SalesOrder(1,"toys");
            SalesOrder s2= new SalesOrder(2,"clothes");
            salesOrderList.add(s1);
            salesOrderList.add(s2);
            return salesOrderList;
        }

    @GetMapping("/get-sales-order-from-business")
    public List<SalesOrder> myApiGettingDataFromBusiness() {
       List<SalesOrder> orders =     businessService.getAllSalesOrder();

       // manipulation logic
       for (SalesOrder order : orders) {
           order.setId(2*order.getId());
       }
       return orders;
    }
}
