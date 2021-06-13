package com.mcdh.tmall.dao;

import com.mcdh.tmall.pojo.Property;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PropertyDao {

    List<Property> getPropertiesByCid(int cid);

    void addProperty(Property property);

    void delProperty(int id);

    Property getPropertyById(int id);

    void updProperty(Property property);
}
