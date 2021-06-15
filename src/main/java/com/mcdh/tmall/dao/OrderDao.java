package com.mcdh.tmall.dao;

import com.mcdh.tmall.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    List<Order> getOrders();
}
