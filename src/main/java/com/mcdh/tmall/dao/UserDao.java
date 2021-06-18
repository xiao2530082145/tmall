package com.mcdh.tmall.dao;

import com.mcdh.tmall.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> getUsers();

    User getUserByName(String name);

    void addUser(User user);
}
