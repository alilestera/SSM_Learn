package com.alilestera.service.impl;

import com.alilestera.common.PageResult;
import com.alilestera.dao.UserDao;
import com.alilestera.domain.User;
import com.alilestera.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Alilestera
 * @date 2/17/2022
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public PageResult findByPage(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.findAll();
        PageInfo pageInfo = new PageInfo(users);
        PageResult pageResult = new PageResult(pageInfo.getPageNum(), pageInfo.getPageSize(), (int) pageInfo.getTotal(), users);
        return pageResult;
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void test() {
        userDao.insertUser(new User(null, "蕾米莉亚", 700, "红魔馆"));
        userDao.insertUser(new User(null, "芙兰朵露", 600, "红魔馆"));
    }
}
