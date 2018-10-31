package com.sakura.service;

import com.sakura.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {

    User selectUser(Integer userId);

    User selectUserName(String username);

    void insertUser(User user);

    boolean updateUser(User user);

}
