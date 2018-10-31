package com.sakura.entity;


public class Reply extends IdEntity {

    private String text_neirong;
    private String text_user;
    private int text_PostN;

    public String getText_neirong() {
        return text_neirong;
    }

    public void setText_neirong(String text_neirong) {
        this.text_neirong = text_neirong;
    }


    public String getText_user() {
        return text_user;
    }

    public void setText_user(String text_user) {
        this.text_user = text_user;
    }

    public int getText_PostN() {
        return text_PostN;
    }

    public void setText_PostN(int text_PostN) {
        this.text_PostN = text_PostN;
    }
}
