package com.sakura.controller;

import com.sakura.entity.Post;
import com.sakura.entity.Reply;
import com.sakura.entity.User;
import com.sakura.service.PostService;
import com.sakura.service.ReplyService;
import com.sakura.tools.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class PostController {


    @Resource
    private ReplyService replyService;


    @Resource
    private PostService postService;



    /**
     * 登录后查看所有帖子以及点击帖子标题进入详细内容查看。
     *
     * @return
     */
    @RequestMapping(value = "/getUserModel.do", method = RequestMethod.POST)
    public ModelAndView getUserModel(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        User user = LoginUtil.getUser(request);
        if (user != null && !"".equals(user)) {
            List<Post> post = postService.selectPost();
            modelAndView.addObject("users", user);
            modelAndView.addObject("posts", post);
            modelAndView.setViewName("tiezi");
        }
        return modelAndView;
    }


    /**
     * 用户发表帖子
     *
     * @param req
     * @param resp
     * @param userId
     * @param text
     * @param username
     * @param title
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/writePost.do", method = RequestMethod.POST)
    public void writePost(HttpServletRequest req, HttpServletResponse resp, @RequestParam Integer userId, String text, String username, String title) throws ServletException, IOException {
        if (userId != null && text != null && username != null && title != null) {
            postService.insertPost(text, username, title);
            req.setAttribute("userId", userId);
            req.getRequestDispatcher("/getUserModel.do").forward(req, resp);
        } else
            return;

    }

    /**
     * 用户的回复
     *
     * @param req
     * @param resp
     * @param text_neirong
     * @param text_user
     * @param text_PostN
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/replyPost.do", method = RequestMethod.GET)
    public void replyPost(HttpServletRequest req, HttpServletResponse resp, @RequestParam String text_neirong, String text_user, int text_PostN) throws ServletException, IOException {
        if (text_neirong != null && text_user != null && text_PostN != 0) {
            replyService.insertReply(text_neirong, text_user, text_PostN);
            req.getRequestDispatcher("/writeView/" + "/" + text_PostN + "/" + text_user).forward(req, resp);
        } else
            return;
    }


    /**
     * 查看帖子的详细内容以及回复
     *
     * @param postNumber
     * @return
     */
    @RequestMapping(value = "/writeView/{postNumber}/{username}", method = RequestMethod.GET)
    public ModelAndView writeView(@PathVariable("postNumber") int postNumber, @PathVariable("username") String username) {
        if (postNumber != 0 && username != null) {

            ModelAndView modelAndView = new ModelAndView();
            Post post = postService.selectOnePost(postNumber);
            modelAndView.addObject("post", post);
            List<Reply> replys = replyService.selectReply(postNumber);
            if (post.getPostUser().equals(username)) {
                modelAndView.addObject("preplys", replys);
            } else {
                modelAndView.addObject("replys", replys);
                modelAndView.addObject("username", username);
            }
            modelAndView.setViewName("PersonalPost");
            return modelAndView;
        } else
            return new ModelAndView("error");
    }


    /**
     * 用户删除自己的帖子
     *
     * @param req
     * @param resp
     * @param userId
     * @param PostNumber
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/deletePost.do", method = RequestMethod.POST)
    public void deletePost(HttpServletRequest req, HttpServletResponse resp, @RequestParam Integer userId, String username, int PostNumber) throws ServletException, IOException {
        if (userId != null && userId != null && PostNumber != 0) {
            Post post = postService.selectOnePost(PostNumber);
            if (post.getPostUser().equals(username)) {
                List<Reply> replies = replyService.selectReply(PostNumber);
                for (Reply r :
                        replies) {
                    replyService.deleteReply(r.getId());
                }
                postService.deletePost(PostNumber);
                req.setAttribute("t", "删除成功");
            } else
                req.setAttribute("t", "这个不是您本人的帖子，无法删除");

            req.setAttribute("userId", userId);
            req.getRequestDispatcher("/getUserModel.do").forward(req, resp);
        } else
            return;
    }


    /**
     * 用户删除自己的回复
     *
     * @param req
     * @param resp
     * @param text_id
     * @param text_PostN
     * @param text_user
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/deleteReply/{text_id}/{text_PostN}/{text_user}", method = RequestMethod.GET)
    public void deleteReply(HttpServletRequest req, HttpServletResponse resp, @PathVariable("text_id") String text_id, @PathVariable("text_PostN") int text_PostN, @PathVariable("text_user") String text_user) throws ServletException, IOException {
        if (text_id != null && text_id != "" && text_PostN != 0 && text_user != null) {

            replyService.deleteReply(Long.parseLong(text_id));
            req.getRequestDispatcher("/writeView/" + "/" + text_PostN + "/" + text_user).forward(req, resp);
        } else
            return;

    }

}
