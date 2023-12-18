package com.example.healthcare2.data.model;

import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("img")
    private int picture;
    @SerializedName("name")

    private String name;

    public Notification(int picture, String name) {
        this.picture = picture;
        this.name = name;
    }
    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "img='" + picture + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
