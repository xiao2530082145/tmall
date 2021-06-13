package com.mcdh.tmall.service.Impl;

import com.mcdh.tmall.dao.PropertyDao;
import com.mcdh.tmall.pojo.Property;
import com.mcdh.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyDao propertyDao;

    @Override
    public List<Property> getPropertiesByCid(int cid) {
        return propertyDao.getPropertiesByCid(cid);
    }

    @Override
    public Property getPropertyById(int id) {
        return propertyDao.getPropertyById(id);
    }

    @Override
    public void addProperty(Property property) {
        propertyDao.addProperty(property);
    }

    @Override
    public void delProperty(int id) {
        propertyDao.delProperty(id);
    }

    @Override
    public void updProperty(Property property) {
        propertyDao.updProperty(property);
    }
}
