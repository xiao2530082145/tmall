package com.mcdh.tmall.controller;

import com.mcdh.tmall.pojo.User;
import com.mcdh.tmall.service.UserService;
import com.mcdh.tmall.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class ForeRESTController {

    @Autowired
    private UserService userService;

    @PostMapping("/foreregister")
    public Object register(@RequestBody User user) {
        String name = user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.userIsExist(user);
        if (exist) {
            String message = "用户名已存在";
            return Result.fail(message);
        }
        userService.addUser(user);
        return Result.success();
    }
}
