package com.sakura.controller;

import com.sakura.entity.User;
import com.sakura.service.*;
import com.sakura.tools.CommUtil;

import com.sakura.tools.LoginUtil;
import com.sakura.tools.TokenProccessor;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


@Controller
public class LoginController {


    @Resource
    private UserService userService;




    /**
     * 登录跳转页面
     */
    @RequestMapping(value = "/sakura/skipLogin.do")
    public ModelAndView skipLogin() {
        return new ModelAndView("login");
    }


    /**
     * 注册页面
     */
    @RequestMapping(value = "/sakura/skipRegister.do")
    public ModelAndView skipRegister() {
        return new ModelAndView("register");
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/sakura/register.do", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response, @RequestParam String username, String password, String code, String email) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        boolean reg = true;
        ModelAndView modelAndView = new ModelAndView();
        //验证码
        if (code != null && "".equals(code)) {
            code = CommUtil.filterHTML(code);

//                if (!request.getSession(false).getAttribute("verify_code").equals(code)){
//                    reg = false;
//                }
        }

        //判断用户名是否重复
        if (username != null && !"".equals(username)) {
            User user = userService.selectUserName(username);
            if (user != null) {
                reg = false;
            }
        }

        if (reg) {
            User user = new User();
            user.setAddress("");
            user.setBirthday(new Date());
            user.setUsername(username);
            user.setSex("男");
            user.setPassword(CommUtil.EncoderByMd5(password));
            user.setEmail(email);
            userService.insertUser(user);
            modelAndView.setViewName("login");
            modelAndView.addObject(user);

        }

        return modelAndView;

    }


    /**
     * 用户登录
     */
    @RequestMapping(value = "/sakura/login.do", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String username, String password) throws IOException, NoSuchAlgorithmException, ServletException {

        ModelAndView modelAndView = new ModelAndView();
        if (username != null && !"".equals(username)) {
            if (password != null) {
                User user = this.userService.selectUserName(username);
                if (user.getPassword().equals(CommUtil.EncoderByMd5(password))) {
                    String userToken = TokenProccessor.getInstance().makeToken();
                    user.setUserToken(userToken);
                    this.userService.updateUser(user);
                    modelAndView.setViewName("tiezi");
                    modelAndView.addObject("user",user);
                    modelAndView.addObject("token",userToken);
                    return modelAndView;
                }
            }
        }else
            modelAndView.setViewName("WEB-INF/views/error");
            return modelAndView;
    }


    /**
     * 用户退出
     * @param request
     * @param response
     * @param user
     * @throws IOException
     */
    @RequestMapping(value = "/sakura/loginout.do")
    public void loginout(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {

        if (user != null && !"".equals(user)) {
            LoginUtil.deletUser(request);
            response.sendRedirect("index.jsp");
        }
    }







}
