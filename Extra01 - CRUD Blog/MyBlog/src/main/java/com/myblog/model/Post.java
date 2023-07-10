package com.myblog.model;

public class Post {
    private int id;
    private String title;
    private String thumbnail;
    private String content;

    public Post() {
    }

    public Post(int id, String title, String thumbnail, String content) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
