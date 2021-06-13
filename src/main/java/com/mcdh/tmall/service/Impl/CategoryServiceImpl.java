package com.mcdh.tmall.service.Impl;

import com.mcdh.tmall.dao.CategoryDao;
import com.mcdh.tmall.pojo.Category;
import com.mcdh.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    public void addCategory(Category category) {
         categoryDao.addCategory(category);
    }

    @Override
    public void delCategory(int id) {
        categoryDao.delCategory(id);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public void updCategory(Category category) {
        categoryDao.updCategory(category);
    }
}
