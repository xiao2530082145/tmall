package com.mcdh.tmall.dao;

import com.mcdh.tmall.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryDao {

    List<Category> getCategories();

    void addCategory(Category category);

    void delCategory(int id);

    Category getCategoryById(int id);

    void updCategory(Category category);
}
