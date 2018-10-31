package com.sakura.dao;

import com.sakura.entity.Reply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyMapper {

    List<Reply> selectReply(@Param("text_PostN")int text_PostN);

    int insertReply(@Param("text_neirong")String text_neirong,@Param("text_user")String text_user,@Param("text_PostN")int text_PostN);

    int deleteReply(@Param("text_id")int text_id);
}
