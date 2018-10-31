package com.sakura.dao;

import com.sakura.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {


    User selectUser(@Param("userId") Integer userId);

    User selectUserName(@Param("username") String username);

    void insertUser(@Param("user")User user);

    boolean updateUser(@Param("user")User user);


}
