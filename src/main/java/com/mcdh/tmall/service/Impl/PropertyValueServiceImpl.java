package com.mcdh.tmall.service.Impl;

import com.mcdh.tmall.dao.CategoryDao;
import com.mcdh.tmall.dao.PropertyDao;
import com.mcdh.tmall.dao.PropertyValueDao;
import com.mcdh.tmall.pojo.Product;
import com.mcdh.tmall.pojo.Property;
import com.mcdh.tmall.pojo.PropertyValue;
import com.mcdh.tmall.service.CategoryService;
import com.mcdh.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {

    @Autowired
    private PropertyValueDao propertyValueDao;
    @Autowired
    private PropertyDao propertyDao;

    @Override
    public List<PropertyValue> getPropertyValues(Product product) {
        return propertyValueDao.getPropertyValues(product);
    }

    @Override
    public PropertyValue getPropertyValueByProductAndProperty(Product product, Property property) {
        return propertyValueDao.getPropertyValueByProductAndProperty(product, property);
    }

    @Override
    public void initPropertyValue(Product product) {
        List<Property> properties = propertyDao.getPropertiesByCid(product.getCategory().getId());
        for (Property property : properties) {
            PropertyValue propertyValue = this.getPropertyValueByProductAndProperty(product, property);
            if (propertyValue == null) {
                propertyValue = new PropertyValue();
                propertyValue.setProperty(property);
                propertyValue.setProduct(product);
                propertyValueDao.addPropertyValue(propertyValue);
            }
        }
    }

    @Override
    public void uptPropertyValue(PropertyValue propertyValue) {
        propertyValueDao.uptPropertyValue(propertyValue);
    }

}
