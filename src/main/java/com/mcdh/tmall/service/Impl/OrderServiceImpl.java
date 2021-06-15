package com.mcdh.tmall.service.Impl;

import com.mcdh.tmall.dao.OrderDao;
import com.mcdh.tmall.pojo.Order;
import com.mcdh.tmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    public Order getOrderByOid(int oid) {
        return orderDao.getOrderByOid(oid);
    }

    @Override
    public void uptOrderToDelivery(Order order) {
        orderDao.uptOrderToDelivery(order);
    }
}
