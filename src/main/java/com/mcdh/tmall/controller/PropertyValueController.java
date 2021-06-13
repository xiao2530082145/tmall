package com.mcdh.tmall.controller;

import com.mcdh.tmall.pojo.Product;
import com.mcdh.tmall.pojo.PropertyValue;
import com.mcdh.tmall.service.ProductService;
import com.mcdh.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyValueController {

    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> getPropertyValues(@PathVariable(value = "pid") int pid){
        Product product = productService.getProductById(pid);
        propertyValueService.initPropertyValue(product);
        return propertyValueService.getPropertyValues(product);
    }

    @PutMapping("/propertyValues")
    public PropertyValue uptPropertyValues(@RequestBody PropertyValue propertyValue){
        propertyValueService.uptPropertyValue(propertyValue);
        return propertyValue;
    }

}
