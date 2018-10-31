package com.sakura.dao;

import com.sakura.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {

    int deletePost(@Param("PostNumber")int PostNumber);
    Post selectOnePost(@Param("PostNumber")Integer PostNumber);
    List<Post> selectPost();
    void updatePost(@Param("userId")Integer userId);
    int insertPost(@Param("postText")String PostText,@Param("postUser")String PostUser,@Param("postTitle")String PostTitle);

}
