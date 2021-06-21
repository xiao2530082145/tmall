package com.mcdh.tmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//自动生成get，set方法
@Data
//自动生成toString方法
@ToString
//自动生成全参构造
@AllArgsConstructor
//自动生成无参构造
@NoArgsConstructor

public class Category {
    private int id;
    private String name;
    private List<Product> products;
    private List<List<Product>> productsByRow;
}
