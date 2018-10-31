package com.sakura.dao;

import com.sakura.entity.Game;
import com.sakura.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameMapper {

    List<Game> selectGamesList();

    List<Game> selectGamesTypeList(@Param("gameType")String gameType);


}
