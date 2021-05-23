package com.example.myapplication;

public class clubheadModel {
    int ImageId;
    String name,role,info;

    public clubheadModel(int imageId, String name, String role, String info) {
        ImageId = imageId;
        this.name = name;
        this.role = role;
        this.info = info;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
