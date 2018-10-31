package com.sakura.tools;

import com.sakura.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LoginUtil {

    public static User getUser(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return (User) request.getSession().getAttribute("user");
        }
        return null;
    }

    public static boolean deletUser(HttpServletRequest request){
        if(request.getSession().getAttribute("user") != null){
            request.getSession().removeAttribute("user");
            return true;
        }
        return false;
    }

}
