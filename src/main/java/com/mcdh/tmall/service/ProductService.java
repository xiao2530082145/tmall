package com.mcdh.tmall.service;

import com.mcdh.tmall.pojo.Category;
import com.mcdh.tmall.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductsByCid(int cid);

    void addProduct(Product product);

    void delProduct(int id);

    Product getProductById(int id);

    void updProduct(Product product);

    void fillCategory(Category category);

    void fillCategoryByRow(Category category);

}
