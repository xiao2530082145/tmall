package com.mcdh.tmall.service.Impl;

import com.mcdh.tmall.dao.ProductImageDao;
import com.mcdh.tmall.pojo.Product;
import com.mcdh.tmall.pojo.ProductImage;
import com.mcdh.tmall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageDao productImageDao;


    @Override
    public void addProductImage(ProductImage productImage) {
        productImageDao.addProductImage(productImage);
    }

    @Override
    public List<ProductImage> getProductImageByPidAndType(String type, int pid) {
        return productImageDao.getProductImageByPidAndType(type, pid);
    }

    @Override
    public void delProductImage(ProductImage productImage) {
        productImageDao.delProductImage(productImage);
    }

    @Override
    public ProductImage getProductImageById(int id) {
        return productImageDao.getProductImageById(id);
    }

    @Override
    public void setFirstProductImage(Product product) {
        List<ProductImage> singleImages = getProductImageByPidAndType("single", product.getId());
        if (!singleImages.isEmpty())
            product.setFirstProductImage(singleImages.get(0));
        else
            product.setFirstProductImage(new ProductImage()); //这样做是考虑到产品还没有来得及设置图片，但是在订单后台管理里查看订单项的对应产品图片。

    }

    @Override
    public void setFirstProductImages(List<Product> products) {
        for (Product product : products)
            setFirstProductImage(product);
    }

}
