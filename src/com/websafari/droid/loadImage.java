package com.websafari.droid;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;


import android.R;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class loadImage extends AsyncTask<comObject, Void, comObject>{
	
	@Override
	protected comObject doInBackground(comObject... co) {
	  
		try {	Drawable image=null;
	           	         
	           	if(co[0].getIv()==null){
	           		Log.e("!","quak");
	           	}
				
				URL url = new URL(co[0].getPath()+""+co[0].getFilename()); 
				
	            URLConnection ucon = url.openConnection();

	            InputStream is = ucon.getInputStream();

	            image = Drawable.createFromStream(is, "src");
	            Bitmap img = ((BitmapDrawable)image).getBitmap();

	            try {
	            	File dir = co[0].getC().getCacheDir();
	            	File myFile = new File(dir, co[0].getFilename());

	                FileOutputStream out = new FileOutputStream(myFile);

	                img.compress(Bitmap.CompressFormat.PNG, 90, out);
	                out.flush();
	                out.close();
	         
		         } catch (Exception e) {
		                e.printStackTrace();
		         }

	            co[0].setImg(image);

	            return co[0];
		    } catch (IOException e) {

		        return co[0];
		    }

	}
	
	@Override
	protected void onPostExecute(comObject co){

		if(co.getImg()!=null){
			co.getIv().setImageDrawable(co.getImg());
			co.getAae().setImg(co.getImg());
			
		}else{
			
			co.getIv().setImageResource(com.websafari.droid.R.drawable.oehlogo);
			
		}


		
	}
}