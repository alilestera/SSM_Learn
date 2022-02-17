package com.alilestera.dao;

import com.alilestera.domain.User;

import java.util.List;

/**
 * @author Alilestera
 * @date 2/17/2022
 */
public interface UserDao {
    User findById(Integer id);

    List<User> findAll();

    void insertUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);
}
