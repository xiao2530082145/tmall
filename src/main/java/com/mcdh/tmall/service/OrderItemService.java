package com.mcdh.tmall.service;

import com.mcdh.tmall.pojo.Order;
import com.mcdh.tmall.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getOrderItemsByOrderId(int oid);

    void fill(List<Order> orders);
}
