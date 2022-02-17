package com.alilestera.controller;

import com.alilestera.common.PageResult;
import com.alilestera.common.ResponseResult;
import com.alilestera.domain.User;
import com.alilestera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alilestera
 * @date 2/16/2022
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseResult findUserById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseResult(500, "查询不到人物");
        }
        return new ResponseResult(200, "查询成功", user);
    }

    @GetMapping("/user")
    public ResponseResult findAll() {
        System.out.println(1/0);
        List<User> users = userService.findAll();
        return new ResponseResult(200, "查询成功", users);
    }

    @GetMapping("/user/{pageSize}/{pageNum}")
    public ResponseResult findByPage(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum) {
        PageResult users = userService.findByPage(pageSize, pageNum);
        return new ResponseResult(200, "查询成功", users);
    }

    @PostMapping("/user")
    public ResponseResult insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return new ResponseResult(200, "操作成功");
    }

    @PostMapping("/user/{id}")
    public ResponseResult deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseResult(200, "操作成功");
    }

    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseResult(200, "操作成功");
    }

    @RequestMapping("/user/test")
    public ResponseResult test() {
        userService.test();
        return new ResponseResult(200, "操作成功");
    }
}
