package com.sakura.service;

import com.sakura.entity.Post;

import java.util.List;

public interface PostService {

    Post selectOnePost(Integer PostNumber);
    int deletePost(int PostNumber);
    List<Post> selectPost();
    int insertPost(String PostText, String PostUser, String PostTitle);
}
