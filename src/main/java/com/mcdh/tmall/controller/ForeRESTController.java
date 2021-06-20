package com.mcdh.tmall.controller;

import com.mcdh.tmall.pojo.User;
import com.mcdh.tmall.service.UserService;
import com.mcdh.tmall.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

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

    @PostMapping("/forelogin")
    public Object login(@RequestBody User user, HttpSession httpSession) {
        String name = user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        User curUser = userService.getUserByNameAndPassword(user);
        if (curUser == null) {
            String message = "账号或密码错误";
            return Result.fail(message);
        } else {
            user.setPassword("");
            httpSession.setAttribute("user", user);
            return Result.success();
        }
    }


}
