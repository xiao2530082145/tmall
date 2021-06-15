package com.mcdh.tmall.dao;

import com.mcdh.tmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemDao {

    List<OrderItem> getOrderItemsByOrderId(int oid);
}
