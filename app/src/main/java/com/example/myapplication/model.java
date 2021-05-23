package com.example.myapplication;

public class model {
    int ImageId;
    String view1,view2;
    public model( String view1, String view2,int imageId) {
        ImageId = imageId;
        this.view1 = view1;
        this.view2 = view2;
    }



    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getView1() {
        return view1;
    }

    public void setView1(String view1) {
        this.view1 = view1;
    }

    public String getView2() {
        return view2;
    }

    public void setView2(String view2) {
        this.view2 = view2;
    }
}