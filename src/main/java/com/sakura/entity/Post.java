package com.sakura.entity;

public class Post extends IdEntity{

    //帖子内容
    private String PostText;
    //帖主
    private String PostUser;
    //帖子赞
    private int PostZan;
    //帖子标题
    private String PostTitle;

    //普通用户
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPostText() {
        return PostText;
    }

    public void setPostText(String postText) {
        PostText = postText;
    }

    public String getPostUser() {
        return PostUser;
    }

    public void setPostUser(String postUser) {
        PostUser = postUser;
    }

    public int getPostZan() {
        return PostZan;
    }

    public void setPostZan(int postZan) {
        PostZan = postZan;
    }

    public String getPostTitle() {
        return PostTitle;
    }

    public void setPostTitle(String postTitle) {
        PostTitle = postTitle;
    }

}
