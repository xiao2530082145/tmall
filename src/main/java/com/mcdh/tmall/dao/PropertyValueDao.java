package com.mcdh.tmall.dao;

import com.mcdh.tmall.pojo.Product;
import com.mcdh.tmall.pojo.Property;
import com.mcdh.tmall.pojo.PropertyValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PropertyValueDao {

    List<PropertyValue> getPropertyValues(Product product);

    void addPropertyValue(PropertyValue propertyValue);

    PropertyValue getPropertyValueByProductAndProperty(Product product, Property property);

    void uptPropertyValue(PropertyValue propertyValue);

}
