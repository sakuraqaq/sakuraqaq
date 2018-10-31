package com.sakura.service;

import com.sakura.dao.GameMapper;
import com.sakura.dao.PostMapper;
import com.sakura.entity.Game;
import com.sakura.entity.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GameServiceImp implements GameService {

    @Resource
    private GameMapper gameMapper;


    @Override
    public List<Game> selectGamesList() {
        return this.gameMapper.selectGamesList();
    }

    @Override
    public List<Game> selectGamesTypeList(String gameType) {
        return this.gameMapper.selectGamesTypeList(gameType);
    }
}
