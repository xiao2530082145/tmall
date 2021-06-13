package com.mcdh.tmall.service.Impl;

import com.mcdh.tmall.dao.UserDao;
import com.mcdh.tmall.pojo.User;
import com.mcdh.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
