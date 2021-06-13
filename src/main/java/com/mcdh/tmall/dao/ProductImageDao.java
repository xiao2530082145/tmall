package com.mcdh.tmall.dao;

import com.mcdh.tmall.pojo.ProductImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductImageDao {

    void addProductImage(ProductImage productImage);

    List<ProductImage> getProductImageByPidAndType(String type, int pid);

    void delProductImage(ProductImage productImage);

    ProductImage getProductImageById(int id);
}
