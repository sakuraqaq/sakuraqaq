package com.sakura.entity;

public class Game extends IdEntity {

    private String gameName;
    private User user;
    private String gameType;
    private String gameImages;
    private String gamePreface;
    private String gameTag;


    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameImages() {
        return gameImages;
    }

    public void setGameImages(String gameImages) {
        this.gameImages = gameImages;
    }

    public String getGamePreface() {
        return gamePreface;
    }

    public void setGamePreface(String gamePreface) {
        this.gamePreface = gamePreface;
    }

    public String getGameTag() {
        return gameTag;
    }

    public void setGameTag(String gameTag) {
        this.gameTag = gameTag;
    }
}
