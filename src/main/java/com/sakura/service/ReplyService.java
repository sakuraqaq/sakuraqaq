package com.sakura.service;

import com.sakura.entity.Reply;

import java.util.List;

public interface ReplyService {

    List<Reply> selectReply(int text_PostN);

    int insertReply(String text_neirong,String text_user,int text_PostN);

    int deleteReply(Long text_id);

}
