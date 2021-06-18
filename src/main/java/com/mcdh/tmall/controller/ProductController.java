package com.mcdh.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcdh.tmall.dao.ProductDao;
import com.mcdh.tmall.dao.ProductImageDao;
import com.mcdh.tmall.pojo.Product;
import com.mcdh.tmall.service.ProductImageService;
import com.mcdh.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;

    @GetMapping("/categories/{cid}/products")
    public PageInfo<Product> getProductsByCid(@PathVariable(value = "cid") int cid,
                                              @RequestParam(value = "start", defaultValue = "1") int start) {
        PageHelper.startPage(start, 8);
        List<Product> list = productService.getProductsByCid(cid);
        productImageService.setFirstProductImages(list);
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        product.setCreateDate(new Date());
        productService.addProduct(product);
        return product;
    }

    @DeleteMapping("/products/{id}")
    public Product delProduct(@PathVariable(value = "id") int id) {
        productService.delProduct(id);
        return null;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable(value = "id") int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/products")
    public Product updProduct(@RequestBody Product product) {
        productService.updProduct(product);
        return product;
    }

}
