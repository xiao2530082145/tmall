package com.mcdh.tmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private String subTitle;
    private double originalPrice;
    private double promotePrice;
    private int stock;
    private Category category;
    private Date createDate;
    private ProductImage firstProductImage;
}
