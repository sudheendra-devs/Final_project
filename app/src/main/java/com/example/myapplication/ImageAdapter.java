package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public Integer[] pics = {


             };
    public ImageAdapter(Context c)
    {context = c;}


    @Override
    public int getCount() {
        return pics.length;
    }

    @Override
    public Object getItem(int position) {
        return pics[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(pics[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(240,240));
        return imageView;
    }
}
