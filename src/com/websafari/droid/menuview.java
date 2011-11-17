package com.websafari.droid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class menuview extends Activity {
    /** Called when the activity is first created. */
	private TextView textView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);
        
        //textView = (TextView) this.findViewById(R.id.tv1);
        
//
        GridView gridview = (GridView) findViewById(R.id.gv);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                
            	switch(position){
            		case 0:	            Intent myIntent = new Intent(v.getContext(), ohoo.class);
            							startActivity(myIntent);
//            		case 1:				// appointments???????
//            		case 2:				// contacts (ähnlich den links)
//            		case 3:				// events 
//            		case 4:				// hours stundenplan
//            		case 5:				// levis 
//            		case 6:				// market kleinanzeigen
//            		case 7:				// canteen mensa später
//            		case 8:				// shoutbox rausgefallen?
//            		case 9:				// survey	später
//            		case 10:			// links	(ähnlich den kontakten)
//            		case 11:			// preferences (hintergrund ändern)
//            		default: 			// default
            	}
                
            }

        });
    }    
}
