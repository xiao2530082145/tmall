package com.mcdh.tmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 25300
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductImage {
    private int id;
    private String type;
    private Product product;
}
