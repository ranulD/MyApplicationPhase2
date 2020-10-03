package com.example.ranul.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * * Created by Ranul on 8/9/2019.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;

    public Integer[] images = {
            R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4,
    };

    public ImageAdapter(Context c){
        context = c;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int positon) {
        return images[positon];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(240, 240));

        return imageView;
    }
}
