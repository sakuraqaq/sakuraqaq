package com.sakura.service;

import com.sakura.dao.PostMapper;
import com.sakura.entity.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostServiceImp implements PostService {

    @Resource
    private PostMapper postMapper;


    @Override
    public int deletePost(int PostNumber) {

        return postMapper.deletePost(PostNumber);

    }


    @Override
    public Post selectOnePost(Integer PostNumber) {
        return postMapper.selectOnePost(PostNumber);
    }

    @Override
    public List<Post> selectPost() {
        return postMapper.selectPost();
    }


    @Override
    public int insertPost(String PostText, String PostUser, String PostTitle) {
        return postMapper.insertPost(PostText,PostUser,PostTitle);
    }



}
