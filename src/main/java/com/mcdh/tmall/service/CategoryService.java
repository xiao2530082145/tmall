package com.mcdh.tmall.service;

import com.mcdh.tmall.pojo.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    void addCategory(Category category);

    void delCategory(int id);

    Category getCategoryById(int id);

    void updCategory(Category category);

}
