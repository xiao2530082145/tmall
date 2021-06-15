package com.mcdh.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcdh.tmall.pojo.Order;
import com.mcdh.tmall.service.OrderItemService;
import com.mcdh.tmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orders")
    public PageInfo<Order> getOrders(@RequestParam(value = "start", defaultValue = "1") int start) {
        PageHelper.startPage(start, 8);
        List<Order> list = orderService.getOrders();
        orderItemService.fill(list);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
