package com.sakura.controller;


import com.sakura.entity.User;
import com.sakura.service.UserService;
import com.sakura.tools.CommUtil;
import com.sakura.tools.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class AccountController {

    @Resource
    private UserService userService;


    /**
     * 显示用户个人信息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/sakura/user_account.do")
    public ModelAndView user_update(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new ModelAndView();

        User user = (User) LoginUtil.getUser(request);

        if (user != null && !"".equals(user)) {

            mv.addObject("user", user);

        }

        mv.setViewName("user_account");


        return mv;
    }


    /**
     * 修改用户个人信息
     *
     * @param request
     * @param response
     * @param birthday
     * @param sex
     * @param address
     * @param tele
     */
    @RequestMapping(value = "/sakura/user_update.do")
    public void user_account(HttpServletRequest request, HttpServletResponse response, String age, String birthday, String sex, String address, String tele) throws IOException {
        try {
            User user = (User) LoginUtil.getUser(request);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (user != null && !"".equals(user)) {

                if (age != null && !"".equals(age)) {
                    user.setAge(Integer.getInteger(age));
                }
                if (birthday != null && !"".equals(birthday)) {
                    Date date = sdf.parse(birthday);
                    user.setBirthday(date);
                }
                if (sex != null && !"".equals(sex)) {
                    user.setSex(sex);
                }
                if (address != null && !"".equals(address)) {
                    user.setAddress(address);
                }
                if (tele != null && !"".equals(tele)) {
                    user.setTele(tele);
                }
                this.userService.updateUser(user);

                response.sendRedirect("user.jsp");
            }
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }

    }


    /**
     * 修改密码
     *
     * @param request
     * @param response
     * @param new_password
     */
    @RequestMapping(value = "/sakura/user_update_password.do")
    public void user_update_password(HttpServletRequest request, HttpServletResponse response, String password, String new_password) {


        try {
            User user = (User) LoginUtil.getUser(request);
            if (user != null && !"".equals(user)) {
                if (new_password != null && !"".equals(new_password)) {
                    if (user.getPassword().equals(password)) {
                        user.setPassword(CommUtil.EncoderByMd5(new_password));
                        this.userService.updateUser(user);
                        response.sendRedirect("user.jsp");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 头像上传
     * @param request
     * @param response
     * @param file
     * @throws IOException
     */
    @RequestMapping(value = "/sakura/user_upload.do" ,method = RequestMethod.POST)
    public void user_upload(HttpServletRequest request, HttpServletResponse response, MultipartFile file) throws IOException {

        User user = (User) LoginUtil.getUser(request);
        //保存数据库的路径
        String sqlPath = null;
        //定义文件保存的本地路径
        String localPath = request.getSession().getServletContext().getRealPath("")+"/upload/images";
        //定义 文件名
        String filename = null;
        if (!file.isEmpty()) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = file.getContentType();
            //获得文件后缀名
            String suffixName = contentType.substring(contentType.indexOf("/") + 1);
            //得到 文件名
            filename = uuid + "." + suffixName;
            //文件保存路径
            file.transferTo(new File(localPath + filename));
        }
        //把图片的相对路径保存至数据库
        sqlPath = "/upload/images/" + filename;
        user.setImagePath(sqlPath);
        userService.updateUser(user);
        response.sendRedirect("user.jsp");
    }


}


