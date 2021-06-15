package com.mcdh.tmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {

    private int id;
    private Product product;
    private Order order;
    private User user;
    private int number;
}
