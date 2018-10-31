package com.sakura.service;

import com.sakura.dao.ReplyMapper;
import com.sakura.entity.Reply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyServiceImp implements ReplyService {

    @Resource
    private ReplyMapper replyMapper;


    @Override
    public List<Reply> selectReply(int text_PostN) {
        return replyMapper.selectReply(text_PostN);
    }

    @Override
    public int insertReply(String text_neirong, String text_user, int text_PostN) {
        return replyMapper.insertReply(text_neirong,text_user,text_PostN);
    }

    @Override
    public int deleteReply(Long text_id) {
        return 0;
    }

}
