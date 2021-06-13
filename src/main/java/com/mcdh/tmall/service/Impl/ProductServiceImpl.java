package com.mcdh.tmall.service.Impl;

import com.mcdh.tmall.dao.ProductDao;
import com.mcdh.tmall.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements com.mcdh.tmall.service.ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProductsByCid(int cid) {
        return productDao.getProductsByCid(cid);
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void delProduct(int id) {
        productDao.delProduct(id);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    public void updProduct(Product product) {
        productDao.updProduct(product);
    }
}
