package com.mcdh.tmall.service;

import com.mcdh.tmall.pojo.Product;
import com.mcdh.tmall.pojo.ProductImage;

import java.util.List;

public interface ProductImageService {

    void addProductImage(ProductImage productImage);

    List<ProductImage> getProductImageByPidAndType(String type, int pid);

    void delProductImage(ProductImage productImage);

    ProductImage getProductImageById(int id);

    void setFirstProductImage(Product product);

    void setFirstProductImages(List<Product> products);
}
