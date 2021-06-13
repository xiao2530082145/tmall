package com.mcdh.tmall.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcdh.tmall.pojo.Product;
import com.mcdh.tmall.pojo.ProductImage;
import com.mcdh.tmall.service.Impl.ProductImageServiceImpl;
import com.mcdh.tmall.service.ProductImageService;
import com.mcdh.tmall.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductImageController {

    private static final String type_single = "single";
    private static final String type_detail = "detail";

    @Autowired
    private ProductImageService productImageService;

    @GetMapping("/products/{pid}/productImages")
    public List<ProductImage> getProductImages(@PathVariable(value = "pid") int pid,
                                               @RequestParam(value = "type") String type) {
        if (!type.equals(type_single) && !type.equals(type_detail)) {
            return new ArrayList<>();
        }
        return productImageService.getProductImageByPidAndType(type, pid);
    }


    @PostMapping("/productImages")
    public ProductImage addProductImage(@RequestParam(value = "pid") int pid,
                                        @RequestParam(value = "type") String type,
                                        MultipartFile image,
                                        HttpServletRequest request) {

        Product product = new Product();
        product.setId(pid);
        ProductImage productImage = new ProductImage();
        productImage.setType(type);
        productImage.setProduct(product);

        productImageService.addProductImage(productImage);


        File imageFolder = getFile(request, productImage);
        File file = new File(imageFolder, productImage.getId() + ".jpg");
        String fileName = file.getName();
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try {
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ProductImageController.type_single.equals(productImage.getType())) {
            String imageFolder_small = request.getServletContext().getRealPath("img/productSingle_small");
            String imageFolder_middle = request.getServletContext().getRealPath("img/productSingle_middle");
            File f_small = new File(imageFolder_small, fileName);
            File f_middle = new File(imageFolder_middle, fileName);
            f_small.getParentFile().mkdirs();
            f_middle.getParentFile().mkdirs();
            ImageUtil.resizeImage(file, 56, 56, f_small);
            ImageUtil.resizeImage(file, 217, 190, f_middle);
        }
        return productImage;
    }

    @DeleteMapping("/productImages/{id}")
    public ProductImage delProductImage(@PathVariable(value = "id") int id, HttpServletRequest request) {
        ProductImage productImage = productImageService.getProductImageById(id);
        productImageService.delProductImage(productImage);

        File imageFolder = getFile(request, productImage);
        File file = new File(imageFolder, productImage.getId() + ".jpg");
        String fileName = file.getName();
        file.delete();
        if (ProductImageController.type_single.equals(productImage.getType())) {
            String imageFolder_small = request.getServletContext().getRealPath("img/productSingle_small");
            String imageFolder_middle = request.getServletContext().getRealPath("img/productSingle_middle");
            File f_small = new File(imageFolder_small, fileName);
            File f_middle = new File(imageFolder_middle, fileName);
            f_small.delete();
            f_middle.delete();
        }
        return null;
    }

    private File getFile(HttpServletRequest request, ProductImage productImage) {
        String folder = "img/";
        if (ProductImageController.type_single.equals(productImage.getType()))
            folder += "productSingle";
        else
            folder += "productDetail";

        return new File(request.getServletContext().getRealPath(folder));
    }

}
