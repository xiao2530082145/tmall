package com.mcdh.tmall.service.Impl;

import com.mcdh.tmall.dao.OrderItemDao;
import com.mcdh.tmall.pojo.Order;
import com.mcdh.tmall.pojo.OrderItem;
import com.mcdh.tmall.service.OrderItemService;
import com.mcdh.tmall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private ProductImageService productImageService;

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int oid) {
        return orderItemDao.getOrderItemsByOrderId(oid);
    }

    @Override
    public void fill(List<Order> orders) {
        for (Order order : orders) {
            int totalNumber = 0;
            double total = 0;
            List<OrderItem> orderItems =  orderItemDao.getOrderItemsByOrderId(order.getId());
            for (OrderItem orderItem : orderItems) {
                productImageService.setFirstProductImage(orderItem.getProduct());
                totalNumber += orderItem.getNumber();
                total += (orderItem.getProduct().getPromotePrice()) * orderItem.getNumber();
            }
            order.setOrderItems(orderItems);
            order.setTotalNumber(totalNumber);
            order.setTotal(total);
        }
    }
}
