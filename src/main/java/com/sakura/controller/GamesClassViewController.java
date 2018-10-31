package com.sakura.controller;

import com.sakura.entity.Game;
import com.sakura.entity.User;
import com.sakura.service.GameService;
import com.sakura.service.UserService;
import com.sakura.tools.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class GamesClassViewController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;


    /**
     * 游戏列表页面
     * @param request
     * @param response
     * @param gameType
     * @return
     */
    public ModelAndView games_view_list(HttpServletRequest request, HttpServletResponse response,@RequestParam String gameType){
        ModelAndView mv = new ModelAndView();
        User user = LoginUtil.getUser(request);
        if(gameType != null && gameType != ""){

        }else {
            if(user != null){
                List<Game> games = this.gameService.selectGamesList();
                mv.addObject("games",games);
            }
        }
        mv.setViewName("gameView");
        return mv;
    }
}
