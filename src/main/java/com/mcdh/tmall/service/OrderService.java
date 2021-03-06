package com.mcdh.tmall.service;

import com.mcdh.tmall.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    Order getOrderByOid(int oid);

    void uptOrderToDelivery(Order order);

}
