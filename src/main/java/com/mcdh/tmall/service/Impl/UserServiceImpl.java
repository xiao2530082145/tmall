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

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public boolean userIsExist(User user) {
        User curUser = getUserByName(user.getName());
        return curUser != null;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserByNameAndPassword(User user) {
        return userDao.getUserByNameAndPassword(user);
    }


}
