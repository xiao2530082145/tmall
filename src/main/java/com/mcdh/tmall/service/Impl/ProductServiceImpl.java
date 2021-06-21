package com.mcdh.tmall.service.Impl;

import com.mcdh.tmall.dao.ProductDao;
import com.mcdh.tmall.pojo.Category;
import com.mcdh.tmall.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public void fillCategory(Category category) {
        int cid = category.getId();
        List<Product> products = productDao.getProductsByCid(cid);
        category.setProducts(products);
    }

    @Override
    public void fillCategoryByRow(Category category) {
        int rowNumber = 8;
        List<Product> products = category.getProducts();
        List<Product> curProducts = null;
        List<List<Product>> productsByRow = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (i % rowNumber == 0) {
                curProducts = new ArrayList<>();
                productsByRow.add(curProducts);
            }
            curProducts.add(products.get(i));
        }
        category.setProductsByRow(productsByRow);
    }
}
