package com.mcdh.tmall.dao;

import com.mcdh.tmall.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductDao {

    List<Product> getProductsByCid(int cid);

    void addProduct(Product product);

    void delProduct(int id);

    Product getProductById(int id);

    void updProduct(Product product);
}
