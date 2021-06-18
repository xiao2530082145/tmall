package com.mcdh.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcdh.tmall.pojo.Category;
import com.mcdh.tmall.pojo.Property;
import com.mcdh.tmall.service.CategoryService;
import com.mcdh.tmall.service.PropertyService;
import com.mcdh.tmall.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/categories")
    public PageInfo<Category> getCategories(@RequestParam(value = "start", defaultValue = "1") int start) {
        PageHelper.startPage(start, 8);
        List<Category> categories = categoryService.getCategories();
        PageInfo<Category> pageInfo = new PageInfo<>(categories);
        return pageInfo;
    }

    @PostMapping("/categories")
    public Category addCategory(Category category, MultipartFile image, HttpServletRequest request) throws IOException {
        categoryService.addCategory(category);
        addOrUpdImage(category, image, request);
        return category;
    }

    @DeleteMapping("/categories/{id}")
    public Category delCategory(@PathVariable(value = "id") int id, HttpServletRequest request) {
        List<Property> list = propertyService.getPropertiesByCid(id);
        if (list.size() != 0) {
            return categoryService.getCategoryById(id);
        } else {
            categoryService.delCategory(id);
            File imageFolder = new File(request.getServletContext().getRealPath("/img/category"));
            File image = new File(imageFolder, id + ".jpg");
            image.delete();
            return null;
        }

    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable(value = "id") int id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public Category updCategory(Category category, MultipartFile image, HttpServletRequest request) throws IOException {
        categoryService.updCategory(category);
        addOrUpdImage(category, image, request);
        return category;
    }

    private void addOrUpdImage(Category category, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, category.getId() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }
}
