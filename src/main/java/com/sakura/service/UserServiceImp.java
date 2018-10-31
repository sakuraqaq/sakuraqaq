package com.sakura.service;

import com.sakura.dao.UserMapper;
import com.sakura.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUser(Integer userId) {

        return userMapper.selectUser(userId);

    }

    @Override
    public User selectUserName(String username){

        return userMapper.selectUserName(username);
    }

    @Override
    public void insertUser(User user) {
         userMapper.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }


}
