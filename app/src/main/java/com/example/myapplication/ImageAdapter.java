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
                R.drawable.image0,R.drawable.image1,R.drawable.raj,R.drawable.vishnupriya,R.drawable.vaishnavi,R.drawable.sumanth,R.drawable.sudheendra,R.drawable.uma,R.drawable.akhila,R.drawable.jeetank,R.drawable.img1,
            R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.prashant,R.drawable.prabhav
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
