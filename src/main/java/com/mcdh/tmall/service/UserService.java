package com.mcdh.tmall.service;

import com.mcdh.tmall.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserByName(String name);

    boolean userIsExist(User user);

    void addUser(User user);
}
