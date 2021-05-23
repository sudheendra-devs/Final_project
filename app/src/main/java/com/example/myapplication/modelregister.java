package com.example.myapplication;

import android.widget.Button;

public class modelregister {
    String activity, link;
    int ImageId;

    public modelregister(String activity, String link, int imageId) {
        this.activity = activity;
        this.link = link;
        ImageId = imageId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }
}