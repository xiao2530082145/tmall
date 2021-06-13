package com.mcdh.tmall.service;

import com.mcdh.tmall.pojo.Property;

import java.util.List;

public interface PropertyService {

    List<Property> getPropertiesByCid(int cid);

    Property getPropertyById(int id);

    void addProperty(Property property);

    void delProperty(int id);

    void updProperty(Property property);


}
