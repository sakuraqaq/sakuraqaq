package com.sakura.service;

import com.sakura.entity.Game;
import com.sakura.entity.Post;

import java.util.List;

public interface GameService {

    List<Game> selectGamesList();

    List<Game> selectGamesTypeList(String gameType);


}
