package com.alilestera.service;

import com.alilestera.common.PageResult;
import com.alilestera.domain.User;

import java.util.List;

/**
 * @author Alilestera
 * @date 2/16/2022
 */
public interface UserService {
    User findById(Integer id);

    List<User> findAll();

    PageResult findByPage(Integer pageSize, Integer pageNum);

    void insertUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

    void test();
}
