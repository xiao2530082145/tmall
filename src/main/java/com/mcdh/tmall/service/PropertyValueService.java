package com.mcdh.tmall.service;

import com.mcdh.tmall.pojo.Product;
import com.mcdh.tmall.pojo.Property;
import com.mcdh.tmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {

    List<PropertyValue> getPropertyValues(Product product);

    PropertyValue getPropertyValueByProductAndProperty(Product product, Property property);

    void initPropertyValue(Product product);

    void uptPropertyValue(PropertyValue propertyValue);

}
