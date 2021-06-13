package com.mcdh.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcdh.tmall.pojo.User;
import com.mcdh.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public PageInfo<User> getUsers(@RequestParam(value = "start", defaultValue = "1") int start) {
        PageHelper.startPage(start, 8);
        List<User> list = userService.getUsers();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
