package com.websafari.droid;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class news_singleview extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Bundle extras = getIntent().getExtras();
        
        String title = extras.getString("title");
        String sub_title = extras.getString("sub_title");
        String img_path = extras.getString("img_path");
        String date = extras.getString("date");
        String text = extras.getString("text");
        
        setContentView(R.layout.news_singleview);
        
        TextView tv_date_sv = (TextView)findViewById(R.id.date_news_singleview);
        tv_date_sv.setText(date);
        
        TextView tv_title_sv = (TextView)findViewById(R.id.title_news_singleview);
        tv_title_sv.setText(title);
        
        TextView tv_text_sv = (TextView)findViewById(R.id.text_news_singleview);
        tv_text_sv.setText(text);
        
        TextView tv_subtitle_sv = (TextView)findViewById(R.id.sub_title_news_singleview);
        tv_subtitle_sv.setText(sub_title);
        
        ImageView tv_img_sv = (ImageView)findViewById(R.id.img_news_singleview);
        
        try {
   
			FileInputStream	in = new FileInputStream(img_path);
			BufferedInputStream bis = new BufferedInputStream(in);
			Bitmap bMap = BitmapFactory.decodeStream(bis);
			tv_img_sv.setImageBitmap(bMap);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
	}

}
