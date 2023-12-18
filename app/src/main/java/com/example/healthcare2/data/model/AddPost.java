package com.example.healthcare2.data.model;

import com.google.gson.annotations.SerializedName;

public class AddPost {
    @SerializedName("btnadd")

    private int btnAddImage;
    @SerializedName("name")

    private String titlePost;
    @SerializedName("content")

    private String content;

    public AddPost(int btnAddImage, String titlePost, String content) {
        this.btnAddImage = btnAddImage;
        this.titlePost = titlePost;
        this.content = content;
    }

    public int getBtnAddImage() {
        return btnAddImage;
    }

    public void setBtnAddImage(int btnAddImage) {
        this.btnAddImage = btnAddImage;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public void setTitlePost(String titlePost) {
        this.titlePost = titlePost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AddPost{" +
                "btnadd='" + btnAddImage + '\'' +
                ", name='" + titlePost + '\'' +
                ", content=" + content +
                '}';
    }
}
