package com.in28minutes.unittesting.unittesting.controller;

import com.in28minutes.unittesting.unittesting.business.*;
import com.in28minutes.unittesting.unittesting.model.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.skyscreamer.jsonassert.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import java.util.*;

@WebMvcTest(MyControllerReturningObject.class)
public class MyControllerReturningObjectTest {

   @Autowired
    MockMvc mockMvc;

   @MockBean
    MyBusinessService myBusinessService;

    @Test
    public void getSalesOrderBasic() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/get-sales-order")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request) .andReturn();
        JSONAssert.assertEquals("[{\"id\":1,\"category\":\"toys\"},{\"id\":2,\"category\":\"clothes\"}]",result.getResponse().getContentAsString(),true);
    }

    // beautiful concept of how without touching DB we have tested
    // whole of controller and its manipulation logic..great thing is that
    // this testcase will work even if DB is down
    @Test
    public void getSalesOrderFromService() throws Exception {
        List<SalesOrder> salesOrderList = new ArrayList<>();
        salesOrderList.add(new SalesOrder(122,"mock"));

        Mockito.when(myBusinessService.getAllSalesOrder()).thenReturn(salesOrderList);
        RequestBuilder request = MockMvcRequestBuilders
                .get("/get-sales-order-from-business")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request) .andReturn();
        JSONAssert.assertEquals("[{id:244,category:mock}]",result.getResponse().getContentAsString(),true);
    }
}
