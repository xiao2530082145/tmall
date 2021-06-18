package com.mcdh.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcdh.tmall.pojo.Property;
import com.mcdh.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public PageInfo<Property> getProperties(@PathVariable(value = "cid") int cid,
                                            @RequestParam(value = "start", defaultValue = "1") int start) {
        PageHelper.startPage(start, 8);
        List<Property> list = propertyService.getPropertiesByCid(cid);
        PageInfo<Property> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @GetMapping("/properties/{id}")
    public Property getPropertyById(@PathVariable(value = "id") int id) {
        return propertyService.getPropertyById(id);
    }

    @PostMapping("/properties")
    public Property addProperty(@RequestBody Property property) {
        propertyService.addProperty(property);
        return property;
    }

    @DeleteMapping("/properties/{id}")
    public Property delProperty(@PathVariable(value = "id") int id) {
        propertyService.delProperty(id);
        return null;
    }

    @PutMapping("/properties")
    public Property updProperty(@RequestBody Property property) {
        propertyService.updProperty(property);
        return property;
    }
}
