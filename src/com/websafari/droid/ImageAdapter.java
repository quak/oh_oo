package com.websafari.droid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(40, 40));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

//        imageView.setBackgroundResource(R.drawable.bgblue);
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.iconblue_news, R.drawable.iconblue_appointments,
            R.drawable.iconblue_contacts, R.drawable.iconblue_events,
            R.drawable.iconblue_hours, R.drawable.iconblue_levis, 
            R.drawable.iconblue_market, R.drawable.iconblue_canteen, 
            R.drawable.iconblue_shoutbox, R.drawable.iconblue_survey,
            R.drawable.iconblue_links, R.drawable.iconblue_preferences
    };


}
